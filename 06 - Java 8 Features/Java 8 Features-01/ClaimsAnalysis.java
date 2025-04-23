import java.util.*;
import java.util.stream.*;

class Claim {
    private String claimId;
    private String policyNumber;
    private double claimAmount;
    private String claimDate;
    private String status;

    public Claim(String claimId, String policyNumber, double claimAmount, String claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    public String getClaimId() { return claimId; }
    public String getPolicyNumber() { return policyNumber; }
    public double getClaimAmount() { return claimAmount; }
    public String getClaimDate() { return claimDate; }
    public String getStatus() { return status; }
}

class PolicyClaimStats {
    private String policyNumber;
    private double totalAmount;
    private double averageAmount;

    public PolicyClaimStats(String policyNumber, double totalAmount, double averageAmount) {
        this.policyNumber = policyNumber;
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public double getTotalAmount() { return totalAmount; }
    public double getAverageAmount() { return averageAmount; }

    public String toString() {
        return policyNumber + " - Total: $" + totalAmount + ", Average: $" + averageAmount;
    }
}

public class ClaimsAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C1", "P1", 6000, "2024-01-10", "Approved"),
                new Claim("C2", "P2", 8000, "2024-02-12", "Approved"),
                new Claim("C3", "P1", 7000, "2024-03-15", "Approved"),
                new Claim("C4", "P3", 4000, "2024-04-18", "Pending"),
                new Claim("C5", "P2", 9000, "2024-05-20", "Approved"),
                new Claim("C6", "P4", 12000, "2024-06-22", "Approved"),
                new Claim("C7", "P1", 2000, "2024-07-01", "Approved"),
                new Claim("C8", "P2", 3000, "2024-07-10", "Rejected")
        );

        Map<String, List<Claim>> groupedClaims = claims.stream()
                .filter(c -> c.getStatus().equalsIgnoreCase("Approved") && c.getClaimAmount() > 5000)
                .collect(Collectors.groupingBy(Claim::getPolicyNumber));

        List<PolicyClaimStats> stats = groupedClaims.entrySet().stream()
                .map(entry -> {
                    String policy = entry.getKey();
                    List<Claim> claimList = entry.getValue();
                    double total = claimList.stream().mapToDouble(Claim::getClaimAmount).sum();
                    double average = claimList.stream().mapToDouble(Claim::getClaimAmount).average().orElse(0.0);
                    return new PolicyClaimStats(policy, total, average);
                })
                .sorted(Comparator.comparingDouble(PolicyClaimStats::getTotalAmount).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Top 3 Policies by Total Claim Amount:");
        stats.forEach(System.out::println);
    }
}

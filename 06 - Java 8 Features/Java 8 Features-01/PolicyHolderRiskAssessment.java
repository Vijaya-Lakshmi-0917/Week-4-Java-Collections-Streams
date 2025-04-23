import java.util.*;
import java.util.stream.*;

class PolicyHolder {
    private String holderId;
    private String name;
    private int age;
    private String policyType;
    private double premiumAmount;

    public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }

    public String getHolderId() { return holderId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPolicyType() { return policyType; }
    public double getPremiumAmount() { return premiumAmount; }
}

class RiskAssessment {
    private String holderId;
    private String name;
    private double riskScore;

    public RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    public String getHolderId() { return holderId; }
    public String getName() { return name; }
    public double getRiskScore() { return riskScore; }

    public String toString() {
        return holderId + " - " + name + " - Risk Score: " + String.format("%.2f", riskScore);
    }
}

class RiskAssessmentApp {
    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder("H1", "Alice", 65, "Life", 35000),
                new PolicyHolder("H2", "Bob", 72, "Health", 40000),
                new PolicyHolder("H3", "Charlie", 68, "Life", 30000),
                new PolicyHolder("H4", "David", 61, "Life", 25000),
                new PolicyHolder("H5", "Eve", 59, "Life", 22000),
                new PolicyHolder("H6", "Frank", 70, "Life", 15000)
        );

        List<RiskAssessment> assessments = holders.stream()
                .filter(h -> h.getPolicyType().equalsIgnoreCase("Life") && h.getAge() > 60)
                .map(h -> new RiskAssessment(h.getHolderId(), h.getName(), h.getPremiumAmount() / h.getAge()))
                .sorted(Comparator.comparingDouble(RiskAssessment::getRiskScore).reversed())
                .collect(Collectors.toList());

        Map<String, List<RiskAssessment>> categorized = assessments.stream()
                .collect(Collectors.groupingBy(r -> r.getRiskScore() > 0.5 ? "High Risk" : "Low Risk"));

        categorized.forEach((category, list) -> {
            System.out.println(category + ":");
            list.forEach(System.out::println);
            System.out.println();
        });
    }
}

import java.util.*;
import java.util.stream.*;

class Transaction {
    private String transactionId;
    private String policyNumber;
    private double amount;
    private String transactionDate;
    private boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    public String getTransactionId() { return transactionId; }
    public String getPolicyNumber() { return policyNumber; }
    public double getAmount() { return amount; }
    public String getTransactionDate() { return transactionDate; }
    public boolean isFraudulent() { return isFraudulent; }
}

class FraudStats {
    private String policyNumber;
    private int fraudCount;
    private double totalFraudAmount;

    public FraudStats(String policyNumber, int fraudCount, double totalFraudAmount) {
        this.policyNumber = policyNumber;
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public int getFraudCount() { return fraudCount; }
    public double getTotalFraudAmount() { return totalFraudAmount; }

    public String toString() {
        return policyNumber + " - Fraud Count: " + fraudCount + ", Total Fraud: $" + totalFraudAmount;
    }
}

public class FraudDetection {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", "P1", 15000, "2024-01-10", true),
                new Transaction("T2", "P1", 20000, "2024-01-11", true),
                new Transaction("T3", "P1", 18000, "2024-01-12", true),
                new Transaction("T4", "P1", 16000, "2024-01-13", true),
                new Transaction("T5", "P1", 17000, "2024-01-14", true),
                new Transaction("T6", "P1", 19000, "2024-01-15", true),
                new Transaction("T7", "P2", 11000, "2024-02-01", true),
                new Transaction("T8", "P2", 9000, "2024-02-02", true),
                new Transaction("T9", "P3", 30000, "2024-03-01", true),
                new Transaction("T10", "P3", 25000, "2024-03-02", true)
        );

        Map<String, List<Transaction>> grouped = transactions.stream()
                .filter(t -> t.isFraudulent() && t.getAmount() > 10000)
                .collect(Collectors.groupingBy(Transaction::getPolicyNumber));

        List<FraudStats> stats = grouped.entrySet().stream()
                .map(entry -> {
                    String policy = entry.getKey();
                    List<Transaction> txns = entry.getValue();
                    int count = txns.size();
                    double total = txns.stream().mapToDouble(Transaction::getAmount).sum();
                    return new FraudStats(policy, count, total);
                })
                .filter(f -> f.getFraudCount() > 5 || f.getTotalFraudAmount() > 50000)
                .collect(Collectors.toList());

        System.out.println("ALERT: Suspicious Policies Detected");
        stats.forEach(System.out::println);
    }
}
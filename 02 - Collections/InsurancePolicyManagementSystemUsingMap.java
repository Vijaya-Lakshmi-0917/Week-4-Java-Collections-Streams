import java.util.*;
import java.util.stream.Collectors;

class InsurancePolicy {
    String policyNumber;
    String policyholderName;
    Date expiryDate;
    String coverageType;
    double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Policyholder: " + policyholderName +
                ", ExpiryDate: " + expiryDate + ", Coverage: " + coverageType + ", Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagementSystemUsingMap {
    Map<String, InsurancePolicy> policyMap;
    Map<String, InsurancePolicy> policyLinkedMap;
    Map<String, InsurancePolicy> policyTreeMap;

    public InsurancePolicyManagementSystemUsingMap() {
        policyMap = new HashMap<>();
        policyLinkedMap = new LinkedHashMap<>();
        policyTreeMap = new TreeMap<>(Comparator.comparing((String policyNumber) -> policyMap.get(policyNumber).getExpiryDate()));
    }

    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        policyLinkedMap.put(policy.getPolicyNumber(), policy);
        policyTreeMap.put(policy.getPolicyNumber(), policy);
    }

    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<InsurancePolicy> getPoliciesExpiringSoon() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date thirtyDaysLater = calendar.getTime();

        return policyMap.values().stream()
                .filter(policy -> policy.getExpiryDate().before(thirtyDaysLater))
                .collect(Collectors.toList());
    }

    public List<InsurancePolicy> getPoliciesByPolicyholder(String policyholderName) {
        return policyMap.values().stream()
                .filter(policy -> policy.getPolicyholderName().equalsIgnoreCase(policyholderName))
                .collect(Collectors.toList());
    }

    public void removeExpiredPolicies() {
        Date currentDate = new Date();
        policyMap.values().removeIf(policy -> policy.getExpiryDate().before(currentDate));
        policyLinkedMap.values().removeIf(policy -> policy.getExpiryDate().before(currentDate));
        policyTreeMap.values().removeIf(policy -> policy.getExpiryDate().before(currentDate));
    }

    public void displayPolicies(Map<String, InsurancePolicy> policyCollection) {
        for (InsurancePolicy policy : policyCollection.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystemUsingMap system = new InsurancePolicyManagementSystemUsingMap();

        Calendar cal = Calendar.getInstance();
        cal.set(2023, Calendar.MAY, 20);
        system.addPolicy(new InsurancePolicy("P001", "John Doe", cal.getTime(), "Health", 300));

        cal.set(2023, Calendar.JUNE, 10);
        system.addPolicy(new InsurancePolicy("P002", "Jane Smith", cal.getTime(), "Auto", 400));

        cal.set(2023, Calendar.JULY, 5);
        system.addPolicy(new InsurancePolicy("P003", "Alice Johnson", cal.getTime(), "Home", 250));

        system.displayPolicies(system.policyMap);
    }
}
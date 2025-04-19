import java.util.*;
import java.util.concurrent.TimeUnit;

public class InsurancePolicyManagementSystem {

    static class Policy {
        private String policyNumber;
        private String policyholderName;
        private Date expiryDate;
        private String coverageType;
        private double premiumAmount;

        public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        public String getPolicyNumber() {
            return policyNumber;
        }

        public Date getExpiryDate() {
            return expiryDate;
        }

        public String getCoverageType() {
            return coverageType;
        }

        @Override
        public String toString() {
            return "Policy Number: " + policyNumber + ", Name: " + policyholderName + ", Expiry Date: " + expiryDate +
                    ", Coverage Type: " + coverageType + ", Premium Amount: " + premiumAmount;
        }

        @Override
        public int hashCode() {
            return policyNumber.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Policy policy = (Policy) obj;
            return policyNumber.equals(policy.policyNumber);
        }
    }

    static class InsuranceManagementSystem {

        private Set<Policy> hashSetPolicies = new HashSet<>();
        private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
        private Set<Policy> treeSetPolicies = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));

        public void addPolicyToHashSet(Policy policy) {
            hashSetPolicies.add(policy);
        }

        public void addPolicyToLinkedHashSet(Policy policy) {
            linkedHashSetPolicies.add(policy);
        }

        public void addPolicyToTreeSet(Policy policy) {
            treeSetPolicies.add(policy);
        }

        public void displayAllPolicies() {
            System.out.println("All Unique Policies:");
            displayPolicies(hashSetPolicies);
            displayPolicies(linkedHashSetPolicies);
            displayPolicies(treeSetPolicies);
        }

        private void displayPolicies(Set<Policy> policySet) {
            for (Policy policy : policySet) {
                System.out.println(policy);
            }
        }

        public void displayPoliciesExpiringSoon() {
            Date currentDate = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, 30);
            Date thirtyDaysFromNow = calendar.getTime();

            System.out.println("\nPolicies Expiring Soon (within the next 30 days):");
            for (Policy policy : hashSetPolicies) {
                if (policy.getExpiryDate().before(thirtyDaysFromNow)) {
                    System.out.println(policy);
                }
            }
            for (Policy policy : linkedHashSetPolicies) {
                if (policy.getExpiryDate().before(thirtyDaysFromNow)) {
                    System.out.println(policy);
                }
            }
            for (Policy policy : treeSetPolicies) {
                if (policy.getExpiryDate().before(thirtyDaysFromNow)) {
                    System.out.println(policy);
                }
            }
        }

        public void displayPoliciesByCoverageType(String coverageType) {
            System.out.println("\nPolicies with Coverage Type: " + coverageType);
            for (Policy policy : hashSetPolicies) {
                if (policy.getCoverageType().equals(coverageType)) {
                    System.out.println(policy);
                }
            }
            for (Policy policy : linkedHashSetPolicies) {
                if (policy.getCoverageType().equals(coverageType)) {
                    System.out.println(policy);
                }
            }
            for (Policy policy : treeSetPolicies) {
                if (policy.getCoverageType().equals(coverageType)) {
                    System.out.println(policy);
                }
            }
        }

        public void displayDuplicatePolicies() {
            Set<String> seenPolicyNumbers = new HashSet<>();
            Set<Policy> duplicatePolicies = new HashSet<>();

            for (Policy policy : hashSetPolicies) {
                if (!seenPolicyNumbers.add(policy.getPolicyNumber())) {
                    duplicatePolicies.add(policy);
                }
            }
            for (Policy policy : linkedHashSetPolicies) {
                if (!seenPolicyNumbers.add(policy.getPolicyNumber())) {
                    duplicatePolicies.add(policy);
                }
            }
            for (Policy policy : treeSetPolicies) {
                if (!seenPolicyNumbers.add(policy.getPolicyNumber())) {
                    duplicatePolicies.add(policy);
                }
            }

            System.out.println("\nDuplicate Policies:");
            for (Policy policy : duplicatePolicies) {
                System.out.println(policy);
            }
        }

        public void comparePerformance() {
            System.out.println("\nPerformance Comparison:");

            long startTime = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                addPolicyToHashSet(new Policy("P" + i, "A", new Date(), "Health", 1000.0));
            }
            long endTime = System.nanoTime();
            System.out.println("HashSet Add Time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");

            startTime = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                addPolicyToLinkedHashSet(new Policy("P" + i, "B", new Date(), "Health", 1000.0));
            }
            endTime = System.nanoTime();
            System.out.println("LinkedHashSet Add Time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");

            startTime = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                addPolicyToTreeSet(new Policy("P" + i, "C", new Date(), "Health", 1000.0));
            }
            endTime = System.nanoTime();
            System.out.println("TreeSet Add Time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");

            startTime = System.nanoTime();
            hashSetPolicies.contains(new Policy("P500", "A", new Date(), "Health", 1000.0));
            endTime = System.nanoTime();
            System.out.println("HashSet Search Time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");

            startTime = System.nanoTime();
            linkedHashSetPolicies.contains(new Policy("P500", "B", new Date(), "Health", 1000.0));
            endTime = System.nanoTime();
            System.out.println("LinkedHashSet Search Time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");

            startTime = System.nanoTime();
            treeSetPolicies.contains(new Policy("P500", "C", new Date(), "Health", 1000.0));
            endTime = System.nanoTime();
            System.out.println("TreeSet Search Time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");
        }
    }

    public static void main(String[] args) {
        InsuranceManagementSystem system = new InsuranceManagementSystem();

        Policy policy1 = new Policy("P12345", "A", new Date(1672512000000L), "Health", 500.0);
        Policy policy2 = new Policy("P23456", "B", new Date(1704048000000L), "Auto", 700.0);
        Policy policy3 = new Policy("P34567", "C", new Date(1659657600000L), "Home", 300.0);

        system.addPolicyToHashSet(policy1);
        system.addPolicyToLinkedHashSet(policy1);
        system.addPolicyToTreeSet(policy1);

        system.addPolicyToHashSet(policy2);
        system.addPolicyToLinkedHashSet(policy2);
        system.addPolicyToTreeSet(policy2);

        system.addPolicyToHashSet(policy3);
        system.addPolicyToLinkedHashSet(policy3);
        system.addPolicyToTreeSet(policy3);

        system.displayAllPolicies();
        system.displayPoliciesExpiringSoon();
        system.displayPoliciesByCoverageType("Health");
        system.displayDuplicatePolicies();
        system.comparePerformance();
    }
}
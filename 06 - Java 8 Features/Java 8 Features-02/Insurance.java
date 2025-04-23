import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Policy {
    String policyNumber;
    String holderName;
    double premiumAmount;

    public Policy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getHolderName() { return holderName; }
    public double getPremiumAmount() { return premiumAmount; }

    public String toString() {
        return String.format("Policy[%s, %s, $%.2f]", policyNumber, holderName, premiumAmount);
    }
}

public class Insurance {
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
                new Policy("P001", "Alice Smith", 1500),
                new Policy("P002", "Bob Johnson", 900),
                new Policy("P003", "Charlie Smith", 2200),
                new Policy("P004", "David Adams", 1100),
                new Policy("P005", "Eva Green", 3000),
                new Policy("P006", "Frank Smith", 1750),
                new Policy("P007", "Grace Thompson", 1300)
        );

        List<Policy> highPremium = policies.stream()
                .filter(p -> p.getPremiumAmount() > 1200)
                .collect(Collectors.toList());

        List<Policy> sortedByName = policies.stream()
                .sorted(Comparator.comparing(Policy::getHolderName))
                .collect(Collectors.toList());

        double totalPremium = policies.stream()
                .mapToDouble(Policy::getPremiumAmount)
                .sum();

        policies.forEach(p -> System.out.println(p));

        List<Policy> inRange = policies.stream()
                .filter(p -> p.getPremiumAmount() >= 1000 && p.getPremiumAmount() <= 2000)
                .collect(Collectors.toList());

        Optional<Policy> highestPremium = policies.stream()
                .max(Comparator.comparingDouble(Policy::getPremiumAmount));

        Map<Character, List<Policy>> groupedByInitial = policies.stream()
                .collect(Collectors.groupingBy(p -> p.getHolderName().charAt(0)));

        double averagePremium = policies.stream()
                .mapToDouble(Policy::getPremiumAmount)
                .average()
                .orElse(0.0);

        List<Policy> sortedByPremium = policies.stream()
                .sorted(Comparator.comparingDouble(Policy::getPremiumAmount))
                .collect(Collectors.toList());
        sortedByPremium.forEach(System.out::println);

        boolean anyAbove2000 = policies.stream()
                .anyMatch(p -> p.getPremiumAmount() > 2000);
        System.out.println("Any policy > $2000? " + anyAbove2000);

        Map<String, Long> premiumRanges = policies.stream()
                .collect(Collectors.groupingBy(p -> {
                    double amt = p.getPremiumAmount();
                    if (amt <= 1000) return "$0-$1000";
                    else if (amt <= 2000) return "$1001-$2000";
                    else return ">$2000";
                }, Collectors.counting()));
        System.out.println("Premium Ranges: " + premiumRanges);

        Set<String> uniqueNames = policies.stream()
                .map(Policy::getHolderName)
                .collect(Collectors.toSet());
        System.out.println("Unique Holder Names: " + uniqueNames);

        List<Policy> smiths = policies.stream()
                .filter(p -> p.getHolderName().toLowerCase().contains("smith"))
                .collect(Collectors.toList());
        smiths.forEach(System.out::println);

        Map<String, Double> policyMap = policies.stream()
                .collect(Collectors.toMap(Policy::getPolicyNumber, Policy::getPremiumAmount));
        System.out.println("Policy Map: " + policyMap);

        String textCorpus = "Java stream stream lambda java stream filter map reduce stream lambda Java";
        List<String> words = Arrays.stream(textCorpus.toLowerCase().split("\\W+"))
                .collect(Collectors.toList());

        Map<String, Long> freqMap = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        freqMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        Optional<String> secondMostFreq = freqMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1)
                .map(Map.Entry::getKey)
                .findFirst();
        System.out.println("Second most repeated word: " + secondMostFreq.orElse("None"));
    }
}
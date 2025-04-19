import java.util.*;

public class ImplementABankingSystem {
    Map<String, Double> customerAccounts;
    Map<String, Double> sortedAccounts;
    Queue<String> withdrawalRequests;

    public ImplementABankingSystem() {
        customerAccounts = new HashMap<>();
        sortedAccounts = new TreeMap<>(Comparator.comparing(customerAccounts::get).reversed());
        withdrawalRequests = new LinkedList<>();
    }

    public void addAccount(String accountNumber, double initialBalance) {
        customerAccounts.put(accountNumber, initialBalance);
        updateSortedAccounts();
    }

    public void deposit(String accountNumber, double amount) {
        if (customerAccounts.containsKey(accountNumber)) {
            customerAccounts.put(accountNumber, customerAccounts.get(accountNumber) + amount);
            updateSortedAccounts();
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    public void withdraw(String accountNumber, double amount) {
        if (customerAccounts.containsKey(accountNumber)) {
            double currentBalance = customerAccounts.get(accountNumber);
            if (currentBalance >= amount) {
                customerAccounts.put(accountNumber, currentBalance - amount);
                withdrawalRequests.add(accountNumber);
                updateSortedAccounts();
            } else {
                System.out.println("Insufficient balance for account " + accountNumber);
            }
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    public void processWithdrawalRequests() {
        while (!withdrawalRequests.isEmpty()) {
            String accountNumber = withdrawalRequests.poll();
            System.out.println("Processed withdrawal for account: " + accountNumber);
        }
    }

    public void displayAccounts() {
        System.out.println("Customer Accounts:");
        for (Map.Entry<String, Double> entry : customerAccounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() + " | Balance: " + entry.getValue());
        }
    }

    public void displaySortedAccounts() {
        System.out.println("Accounts Sorted by Balance:");
        for (Map.Entry<String, Double> entry : sortedAccounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() + " | Balance: " + entry.getValue());
        }
    }

    private void updateSortedAccounts() {
        sortedAccounts.clear();
        sortedAccounts.putAll(customerAccounts);
    }

    public static void main(String[] args) {
        ImplementABankingSystem bank = new ImplementABankingSystem();

        bank.addAccount("12345", 1000.0);
        bank.addAccount("67890", 2000.0);
        bank.addAccount("11111", 500.0);

        bank.displayAccounts();
        bank.displaySortedAccounts();

        bank.deposit("12345", 500.0);
        bank.withdraw("67890", 1000.0);

        bank.processWithdrawalRequests();
        bank.displayAccounts();
        bank.displaySortedAccounts();
    }
}
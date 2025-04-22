
    class TransactionException extends Exception {
        public TransactionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public class RethrowingExceptionsWithCustomContext {
        public static void processTransaction(String transactionId, double amount) throws TransactionException {
            try {
                if (amount < 0) {
                    throw new IllegalArgumentException("Amount cannot be negative");
                }
                System.out.println("Processing transaction " + transactionId + " with amount " + amount);
            } catch (Exception e) {
                throw new TransactionException("Failed to process transaction ID: " + transactionId, e);
            }
        }

        public static void main(String[] args) {
            try {
                processTransaction("TXN12345", -500);
            } catch (TransactionException e) {
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

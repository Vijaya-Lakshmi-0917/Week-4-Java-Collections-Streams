class FakeConnection {
    public void connect() {
        System.out.println("Connection established.");
    }

    public void doWork() {
        throw new RuntimeException("Error while working on connection");
    }

    public void close() {
        System.out.println("Connection closed.");
    }
}

public class ExceptionHandlingWithResourceCleanup {
    public static void main(String[] args) {
        FakeConnection connection = new FakeConnection();
        try {
            connection.connect();
            connection.doWork();
        } catch (RuntimeException e) {
            System.err.println("Exception: " + e.getMessage());
        } finally {
            connection.close();
        }
    }
}
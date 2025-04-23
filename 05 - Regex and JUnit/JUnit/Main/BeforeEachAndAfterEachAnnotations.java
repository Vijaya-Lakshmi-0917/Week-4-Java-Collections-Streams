
public class BeforeEachAndAfterEachAnnotations {
    private boolean connected = false;

    public void connect() {
        connected = true;
    }

    public void disconnect() {
        connected = false;
    }

    public boolean isConnected() {
        return connected;
    }
}

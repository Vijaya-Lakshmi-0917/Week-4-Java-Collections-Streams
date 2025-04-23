public class PerformanceTesting {
    public static String longRunningTask() throws InterruptedException {
        Thread.sleep(3000);
        return "Completed";
    }
}

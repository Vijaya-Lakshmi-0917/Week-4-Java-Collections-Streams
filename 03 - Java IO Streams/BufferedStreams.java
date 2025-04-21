import java.io.*;

public class BufferedStreams {

    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\S Vijaya Lakshmi\\documents\\Java.txt";
        String destUnbuffered = "C:\\Users\\S Vijaya Lakshmi\\documents\\Unbuffered.txt";
        String destBuffered = "C:\\Users\\S Vijaya Lakshmi\\documents\\Buffered.txt";

        long unbufferedTime = copyWithUnbufferedStream(sourceFile, destUnbuffered);
        System.out.println("Unbuffered copy time: " + unbufferedTime + " ns");

        long bufferedTime = copyWithBufferedStream(sourceFile, destBuffered);
        System.out.println("Buffered copy time: " + bufferedTime + " ns");

        if (bufferedTime < unbufferedTime) {
            System.out.println("Buffered streams are faster by " + (unbufferedTime - bufferedTime) + " ns.");
        } else {
            System.out.println("Unbuffered streams are faster by " + (bufferedTime - unbufferedTime) + " ns.");
        }
    }

    public static long copyWithUnbufferedStream(String source, String dest) {
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error during unbuffered copy: " + e.getMessage());
        }

        return System.nanoTime() - startTime;
    }

    public static long copyWithBufferedStream(String source, String dest) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error during buffered copy: " + e.getMessage());
        }

        return System.nanoTime() - startTime;
    }
}

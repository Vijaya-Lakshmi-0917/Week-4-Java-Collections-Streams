import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class FileHandling {

    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\S Vijaya Lakshmi\\documents\\Java.txt";
        String destinationFile = "C:\\Users\\S Vijaya Lakshmi\\documents\\JavaDestination.txt";

        File inputFile = new File(sourceFile);
        if (!inputFile.exists()) {
            System.out.println("Source file '" + sourceFile + "' does not exist.");
            return;
        }

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destinationFile);

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully from '" + sourceFile + "' to '" + destinationFile + "'.");

        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing file streams: " + e.getMessage());
            }
        }
    }
}

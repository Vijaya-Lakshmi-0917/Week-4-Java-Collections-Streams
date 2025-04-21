import java.io.*;
import java.util.Arrays;
public class ByteArrayStream {

    public static void main(String[] args) {
        String sourceImage = "C:\\Users\\S Vijaya Lakshmi\\OneDrive\\image 1.jpg";
        String destinationImage = "C:\\Users\\S Vijaya Lakshmi\\OneDrive\\image 2.jpg";

        try {
            byte[] imageBytes = convertImageToByteArray(sourceImage);
            writeByteArrayToImage(imageBytes, destinationImage);
            boolean isIdentical = compareFiles(sourceImage, destinationImage);

            System.out.println("Image copied successfully.");
            System.out.println("Files are identical: " + isIdentical);

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }

    public static byte[] convertImageToByteArray(String filePath) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
        }
        return baos.toByteArray();
    }

    public static void writeByteArrayToImage(byte[] data, String filePath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             FileOutputStream fos = new FileOutputStream(filePath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    public static boolean compareFiles(String file1Path, String file2Path) throws IOException {
        byte[] file1Bytes = convertImageToByteArray(file1Path);
        byte[] file2Bytes = convertImageToByteArray(file2Path);
        return Arrays.equals(file1Bytes, file2Bytes);
    }
}

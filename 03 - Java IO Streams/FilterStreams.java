import java.io.*;

public class FilterStreams {

    public static void main(String[] args) {
        String inputFile = "C:\\Users\\S Vijaya Lakshmi\\documents\\Java.txt";
        String outputFile = "C:\\Users\\S Vijaya Lakshmi\\documents\\JavaDestination.txt";

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File conversion complete. Output written to " + outputFile);

        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }
}

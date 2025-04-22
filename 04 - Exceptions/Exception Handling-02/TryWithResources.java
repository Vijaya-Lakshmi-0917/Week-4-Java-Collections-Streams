import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TryWithResources {

    public void processFiles(List<String> filePaths) {
        for (String path : filePaths) {
            System.out.println("Reading file: " + path);

            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + path);
                System.err.println("Exception: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        TryWithResources processor = new TryWithResources();
        List<String> paths = List.of("file1.txt", "file2.txt", "file3.txt");
        processor.processFiles(paths);
    }
}

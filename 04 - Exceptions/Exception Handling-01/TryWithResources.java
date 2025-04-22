import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class TryWithResources{
    public static void main(String[] args) {
        try(BufferedReader reader= new BufferedReader(new FileReader("info.txt"))){
            String line = reader.readLine();
            if(line!=null){
                System.out.println(line);
            }
            else{
                System.out.println("File is Empty");
            }
        }
        catch (IOException e){
            System.out.println("Error reading the file");
        }
    }
}

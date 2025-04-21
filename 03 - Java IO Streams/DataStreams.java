import java.io.*;

public class DataStreams {

    public static void main(String[] args) {
        String fileName = "C:\\Users\\S Vijaya Lakshmi\\documents\\Java.txt";
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);
            dos.writeUTF("A");
            dos.writeDouble(3.75);

            dos.writeInt(102);
            dos.writeUTF("B");
            dos.writeDouble(3.90);

            System.out.println("Student data written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\nRetrieved Student Data:");
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}

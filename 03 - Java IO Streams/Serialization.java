import java.io.*;
import java.util.*;
class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name +
                ", Department: " + department + ", Salary: " + salary;
    }
}

public class Serialization {

    public static void main(String[] args) {
        String filename = "employees.ser";

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "A", "HR", 50000));
        employeeList.add(new Employee(102, "B", "Engineering", 70000));
        employeeList.add(new Employee(103, "C", "Marketing", 55000));

        serializeEmployees(employeeList, filename);
        List<Employee> deserializedList = deserializeEmployees(filename);

        System.out.println("Deserialized Employee List:");
        for (Employee e : deserializedList) {
            System.out.println(e);
        }
    }

    public static void serializeEmployees(List<Employee> employees, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Employees have been serialized to " + filename);
        } catch (IOException e) {
            System.out.println("IOException during serialization: " + e.getMessage());
        }
    }

    public static List<Employee> deserializeEmployees(String filename) {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException e) {
            System.out.println("IOException during deserialization: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found during deserialization: " + e.getMessage());
        }
        return employees;
    }
}

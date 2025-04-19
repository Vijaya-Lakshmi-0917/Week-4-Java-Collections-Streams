import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

enum Department {
    HR, IT, FINANCE, MARKETING;
}

public class GroupPropertiesByObjects {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", Department.HR));
        employees.add(new Employee("Bob", Department.IT));
        employees.add(new Employee("Carol", Department.HR));
        employees.add(new Employee("David", Department.FINANCE));
        employees.add(new Employee("Eve", Department.IT));

        Map<Department, List<Employee>> groupedByDepartment = groupByDepartment(employees);

        for (Map.Entry<Department, List<Employee>> entry : groupedByDepartment.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<Department, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
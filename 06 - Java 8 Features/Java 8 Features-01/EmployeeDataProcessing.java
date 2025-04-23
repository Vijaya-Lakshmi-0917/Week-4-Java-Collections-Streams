import java.util.*;
import java.util.stream.*;
import java.text.DecimalFormat;

class Employee {
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

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    public String toString() {
        return id + " - " + name + " - " + department + " - $" + salary;
    }
}

class EmployeeProcessor {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 90000),
                new Employee(2, "Bob", "Marketing", 70000),
                new Employee(3, "Charlie", "Engineering", 85000),
                new Employee(4, "David", "Engineering", 75000),
                new Employee(5, "Eve", "HR", 80000),
                new Employee(6, "Frank", "Engineering", 95000)
        );

        List<Employee> filteredSorted = employees.stream()
                .filter(e -> e.getDepartment().equals("Engineering") && e.getSalary() > 80000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        Map<String, List<Employee>> grouped = filteredSorted.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        Map<String, Double> averageSalaries = grouped.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .collect(Collectors.averagingDouble(Employee::getSalary))
                ));

        System.out.println("Filtered and Sorted Employees:");
        filteredSorted.forEach(System.out::println);

        System.out.println("\nGrouped by Department:");
        grouped.forEach((dept, emps) -> {
            System.out.println(dept + ":");
            emps.forEach(System.out::println);
        });

        System.out.println("\nAverage Salary by Department:");
        averageSalaries.forEach((dept, avg) ->
                System.out.println(dept + ": $" + new DecimalFormat("#.00").format(avg))
        );
    }
}
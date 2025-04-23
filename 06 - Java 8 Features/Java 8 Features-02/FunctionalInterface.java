import java.util.*;
import java.util.function.*;
import java.util.stream.*;

@FunctionalInterface
interface Adder {
    int add(int a, int b);
}

@FunctionalInterface
interface Square {
    int calculate(int x);
    default void printSquare(int x) {
        System.out.println("Square of " + x + " is: " + calculate(x));
    }
}

class Person {
    private String name;
    private int age;
    private double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() { return age; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    public String toString() {
        return name + " - Age: " + age + ", Salary: " + salary;
    }
}

class FunctionalInterfaces {
    public static void main(String[] args) {
        Adder adder = (a, b) -> a + b;
        System.out.println("Sum: " + adder.add(10, 20));

        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Charlie", "Ann");
        List<String> filtered = names.stream()
                .filter(name -> !name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Filtered (not starting with A): " + filtered);

        List<Person> people = Arrays.asList(
                new Person("John", 30, 50000),
                new Person("Jane", 25, 60000),
                new Person("Mike", 35, 55000)
        );
        people.sort(Comparator.comparingInt(Person::getAge));
        System.out.println("Sorted by age:");
        people.forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sumOfSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("Sum of squares of even numbers: " + sumOfSquares);

        Predicate<String> lengthCheck = str -> str.length() > 5;
        Predicate<String> containsSub = str -> str.contains("o");
        List<String> testStrings = Arrays.asList("hello", "world", "openai", "java", "functional");
        List<String> composed = testStrings.stream()
                .filter(lengthCheck.and(containsSub))
                .collect(Collectors.toList());
        System.out.println("Filtered with Predicate: " + composed);

        Consumer<String> printer = str -> System.out.println(str.toUpperCase());
        System.out.println("Consumer uppercase:");
        names.forEach(printer);

        Function<Double, Double> areaOfCircle = r -> Math.PI * r * r;
        System.out.println("Area of circle with radius 5: " + areaOfCircle.apply(5.0));

        BiFunction<String, String, String> concatWithSpace = (s1, s2) -> s1 + " " + s2;
        System.out.println("Concatenated string: " + concatWithSpace.apply("Hello", "World"));

        Square square = x -> x * x;
        square.printSquare(6);

        List<Integer> nums = Arrays.asList(12, 45, 3, 78, 2);
        Optional<Integer> max = nums.stream().max(Integer::compareTo);
        System.out.println("Max value: " + max.orElse(-1));

        List<Integer> emptyList = new ArrayList<>();
        Optional<Integer> maxEmpty = emptyList.stream().max(Integer::compareTo);
        System.out.println("Max from empty list: " + maxEmpty.orElse(-1));
    }
}

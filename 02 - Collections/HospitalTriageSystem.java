import java.util.PriorityQueue;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }

    @Override
    public String toString() {
        return name;
    }
}

public class HospitalTriageSystem {

    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>();

        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        while (!queue.isEmpty()) {
            Patient patient = queue.poll();
            System.out.println(patient);
        }
    }
}
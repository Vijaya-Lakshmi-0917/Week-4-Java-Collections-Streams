import java.util.LinkedList;
import java.util.Queue;

public class ReverseAQueue {

    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return queue;
        }

        int front = queue.remove();
        queue = reverseQueue(queue);
        queue.add(front);

        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);

        queue = reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}
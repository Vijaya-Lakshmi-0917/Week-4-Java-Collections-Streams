class CircularBuffer {
    private int[] buffer;
    private int size;
    private int front;
    private int rear;
    private int count;

    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }
    public void insert(int value) {
        if (count == size) {
            front = (front + 1) % size;
        } else {
            count++;
        }

        buffer[rear] = value;
        rear = (rear + 1) % size;
    }
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size]);
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public boolean isFull() {
        return count == size;
    }
}

public class CircularBufferSimulation {
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.display();

        buffer.insert(4);
        buffer.display();

        buffer.insert(5);
        buffer.display();
    }
}
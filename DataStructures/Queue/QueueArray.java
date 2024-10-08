public class QueueArray<T> {
    private T[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return capacity == size;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(T data) {
        if (isFull()) {
            throw new RuntimeException("Full Queue");
        }
        rear = (rear + 1) % capacity;
        array[rear] = data;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty Queue");
        }
        T data = array[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Empty Queue");
        }
        T data = array[front];
        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) { // Itera solo sobre los elementos en cola
            sb.append(array[(front + i) % capacity]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        QueueArray<Integer> queue = new QueueArray<>(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println("Queue after enqueues: " + queue); // [10, 20, 30, 40]

        System.out.println("Dequeued element: " + queue.dequeue()); // 10
        System.out.println("Queue after dequeue: " + queue); // [20, 30, 40]

        System.out.println("Front element: " + queue.peek()); // 20
        System.out.println("Queue size: " + queue.getSize()); // 3
    }
}

package DataStructures.Queue;

import java.util.Iterator;
import java.util.LinkedList;

public class QueueList<T> implements Iterable<T> {

    private LinkedList<T> list = new LinkedList<T>();

    public QueueList() {

    }

    public QueueList(T firstElement) {
        // offer(firstElement);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // returns the element of the front of the queue
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Empty queue");
        return list.peekFirst();
    }

    // removes the element of the front of the queue
    public T poll() {
        if (isEmpty())
            throw new RuntimeException("Empty queue");
        return list.removeFirst();
    }

    // adds an element to the back of the list
    public void offer(T element) {
        list.addLast(element);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}

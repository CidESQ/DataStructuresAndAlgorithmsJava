
public class DoublyLinkedList<T> {

    private int size;
    private NodoDoble<T> head;
    private NodoDoble<T> tail;

    public DoublyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T data) {
        if (isEmpty()) {
            head = tail = new NodoDoble(data, null, null);
        } else {
            head.previous = new NodoDoble(data, null, head);
            head = head.previous;
        }
        size++;
    }

    public void addLast(T data) {
        // NodoDoble<T> nuevoNodo = new NodoDoble<>(data, null, null);
        // if (isEmpty()) {
        // head = nuevoNodo;
        // } else {
        // NodoDoble<T> pointer = head;
        // while (pointer.next != null) {
        // pointer = pointer.next;
        // }
        // pointer.next = nuevoNodo;
        // }
        if (isEmpty()) {
            head = tail = new NodoDoble(data, null, null);
        } else {
            tail.next = new NodoDoble(data, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public T peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        return head.data;
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        return tail.data;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        }
        T extractedData = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        } else {
            head.previous = null;
        }
        return extractedData;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        }
        T extractedData = tail.data;
        tail = tail.previous;
        size--;
        if (isEmpty()) {
            head = null;
        } else {
            tail.next = null;
        }
        return extractedData;
    }

    private T remove(NodoDoble<T> nodo) {
        if (nodo.previous == null) {
            return removeFirst();
        }
        if (nodo.next == null) {
            return removeLast();
        }
        T data = nodo.data;
        nodo.next.previous = nodo.previous;
        nodo.previous.next = nodo.next;
        nodo.data = null;
        nodo = nodo.previous = nodo.next = null;
        size--;
        return data;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size || isEmpty()) {
            throw new RuntimeException("Empty list or index out of bounds");
        }
        int i;
        NodoDoble<T> pointer;
        // Search from the begining of the list
        for (i = 0, pointer = head; i != index; i++) {
            pointer = pointer.next;
        }
        size--;
        return remove(pointer);
    }

    public boolean removeObject(Object o) {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        int i = 0;
        NodoDoble<T> finder = head;
        while (i < size) {
            if (finder.data.equals(o)) {
                removeAt(i);
                return true;
            }
            finder = finder.next;
            i++;
        }
        return false;
    }

    public int indexOf(Object o) {
        NodoDoble<T> pointer = head;
        int index = 0;
        while (pointer != null) {
            if (o.equals(pointer.data)) {
                return index;
            }
            pointer = pointer.next;
            index++;
        }
        return -1;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public void clear() {
        NodoDoble<T> pointer = head;
        while (pointer != null) {
            NodoDoble<T> nextNode = pointer.next;
            pointer.previous = pointer.next = null;
            pointer.data = null;
            pointer = nextNode;
        }
        head = tail = pointer = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        NodoDoble<T> pointer = head;
        while (pointer != null) {
            sb.append(pointer.data + ", ");
            pointer = pointer.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}

class NodoDoble<T> {
    NodoDoble<T> previous;
    NodoDoble<T> next;
    T data;

    public NodoDoble(T data, NodoDoble<T> previous, NodoDoble<T> next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }
}
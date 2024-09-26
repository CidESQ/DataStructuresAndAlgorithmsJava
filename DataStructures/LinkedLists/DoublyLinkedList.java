package DataStructures.LinkedLists;

public class DoublyLinkedList<T> {
    /*
     * TODO:
     * void clear()
     * void addFirst(Object o)
     * void addLast(Object o)
     * T peekFirst()
     * T peekLast()
     * T removeFirst()
     * T removeLast()
     * T removeAt(int index)
     * private remove(NodoDoble<T> nodo)
     * boolean removeObject(Object o)
     * int indexOf(Object o)
     * boolean contains(Object o)
     * String toString()
     */

    private int size;
    private NodoDoble<T> head;

    public DoublyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T data) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(data);
        if (isEmpty()) {
            head = nuevoNodo;
        } else {
            NodoDoble<T> pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;

            }
            pointer.next = nuevoNodo;
        }

    }

    public static void main(String[] args) {

    }
}

class NodoDoble<T> {
    NodoDoble<T> previous;
    NodoDoble<T> next;
    T data;

    public NodoDoble(T data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }
}
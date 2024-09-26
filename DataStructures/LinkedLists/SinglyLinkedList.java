
public class SinglyLinkedList<T> {
    private Nodo<T> head; // Cabeza de la lista
    private int size; // tamaño de la lista

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void add(T data) {
        Nodo<T> nuevoNodo = new Nodo<>(data);
        if (isEmpty()) {
            head = nuevoNodo; // Si la lista esta vacia esta sera la cabeza
        } else {
            Nodo<T> pointer = head;
            // Recorremos hasta el final de la lista
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = nuevoNodo; // Enlazamos el ultimo nodo con el nuevo nodo.
        }
        size++;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Nodo<T> pointer = head;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        return pointer.data;
    }

    public T removeAt(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Nodo<T> pointer = head;
        Nodo<T> previous = null;
        if (index == 0) {
            head = pointer.next; // Si es el primer nodo el que se elimina solo movemos la cabeza un nodo mas
        } else {
            for (int i = 0; i < index; i++) {
                previous = pointer;
                pointer = pointer.next;
            }
            // Saltamos al nodo que queremos eliminar
            previous.next = pointer.next;
        }
        size--;
        return pointer.data;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Nodo<T> pointer = head;
        while (pointer != null) {
            sb.append(pointer.data);
            if (pointer.next != null) {
                sb.append(", ");
            }
            pointer = pointer.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<>();
        s.add(37);
        s.add(67);
        s.add(367);
        s.add(3757);
        System.out.println("lista: " + s.toString());
        System.out.println("Eliminando:" + s.removeAt(3));
        System.out.println("lista: " + s.toString());
    }
}

class Nodo<T> {
    T data; // El valor que guarda el nodo
    Nodo<T> next; // referencia al siguiente nodo

    public Nodo(T data) {
        this.data = data;
        this.next = null;
    }
}


public class CircularLinkedList<T> {
    /*
     * boolean contains()
     */

    private int size;
    private NodoCircular<T> head;
    private NodoCircular<T> tail;

    public CircularLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(T data) {
        NodoCircular<T> newNode = new NodoCircular<>(data, head);
        if (size == 0) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
    }

    public void addLast(T data) {
        if (size == 0) {
            addFirst(data);
        } else {
            NodoCircular<T> newNode = new NodoCircular<>(data, head);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        T data = head.data;
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        T data = tail.data;
        if (size == 1) {
            head = tail = null;
        } else {
            NodoCircular<T> pointer = head;
            while (pointer.next != tail) {
                pointer = pointer.next;
            }
            tail = pointer;
            tail.next = head;
        }
        size--;
        return data;
    }

    public boolean removeObject(Object o) {
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        }
        if (head.data.equals(o)) {
            if (size == 1) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            size--;
            return true;
        }
        NodoCircular<T> pointer = head;
        while (pointer.next != head) {
            if (pointer.next.data.equals(o)) {
                if (pointer.next == tail) {
                    tail = pointer;
                }
                pointer.next = pointer.next.next;
                size--;
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }

    public T peekFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        return tail.data;
    }

    public boolean contains(Object o) {
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        }
        NodoCircular<T> pointer = head;
        do {
            if (pointer.data.equals(o)) {
                return true;
            }
            pointer = pointer.next;
        } while (pointer != head);
        return false;
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        // Agregar elementos
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(30);
        list.addLast(40);

        System.out.println("Contenido después de agregar 4 elementos:");
        System.out.println("Primero: " + list.peekFirst()); // Debería mostrar 20
        System.out.println("Último: " + list.peekLast()); // Debería mostrar 40
        System.out.println("Tamaño: " + list.getSize()); // Debería mostrar 4

        // Eliminar el primer elemento
        System.out.println("\nEliminar el primer elemento: " + list.removeFirst());
        System.out.println("Nuevo primero: " + list.peekFirst()); // Debería mostrar 10

        // Eliminar el último elemento
        System.out.println("\nEliminar el último elemento: " + list.removeLast());
        System.out.println("Nuevo último: " + list.peekLast()); // Debería mostrar 30

        // Verificar si contiene un valor
        System.out.println("\n¿Contiene 10? " + list.contains(10)); // Debería ser true
        System.out.println("¿Contiene 40? " + list.contains(40)); // Debería ser false

        // Eliminar un elemento por objeto
        System.out.println("\nEliminar el 10: " + list.removeObject(10));
        System.out.println("¿Lista vacía? " + list.isEmpty()); // Debería ser false
        System.out.println("Nuevo tamaño: " + list.getSize()); // Debería mostrar 1

        // Ver el contenido final
        System.out.println("\nPrimero: " + list.peekFirst()); // Debería mostrar 30
    }

}

class NodoCircular<T> {
    T data;
    NodoCircular<T> next;

    public NodoCircular(T data, NodoCircular<T> next) {
        this.data = data;
        this.next = next;
    }
}
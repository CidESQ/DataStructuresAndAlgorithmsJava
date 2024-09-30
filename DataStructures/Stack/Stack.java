
//! Stack || Pila

public class Stack<T> {

    int size = 0;
    Nodo<T> top = null;

    public Stack() {
        this.size = 0;
        this.top = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T data) {
        Nodo<T> nuevoNodo = new Nodo<>(data, null);
        if (size == 0) {
            top = nuevoNodo;
        } else {
            nuevoNodo.setLowerNode(top);
            top = nuevoNodo;
        }
        size++;
    }

    public T pop() {
        if (size == 0) {
            throw new RuntimeException("Empty stack");
        }
        Nodo<T> nodoEliminado = top;
        top = nodoEliminado.getLowerNode();
        size--;
        return nodoEliminado.getData();

    }

    public T peek() {
        if (size == 0) {
            throw new RuntimeException("Empty Stack");
        }
        return top.getData();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Agregando elementos a la pila
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Mostrando el tamaño actual de la pila
        System.out.println("Tamaño de la pila: " + stack.getSize()); // Output: 3

        // Mostrando el tope de la pila sin eliminarlo
        System.out.println("Elemento en el tope: " + stack.peek()); // Output: 30

        // Eliminando el tope de la pila
        System.out.println("Elemento eliminado: " + stack.pop()); // Output: 30
        System.out.println("Nuevo tope: " + stack.peek()); // Output: 20

        // Verificando si la pila está vacía
        System.out.println("¿Está vacía?: " + stack.isEmpty()); // Output: false

        // Vaciar la pila completamente
        stack.pop();
        stack.pop();
        System.out.println("¿Está vacía después de eliminar todos los elementos?: " + stack.isEmpty()); // Output: true
    }

}

class Nodo<T> {

    private T data;
    private Nodo<T> lowerNode;

    public Nodo(T data, Nodo<T> lowerNode) {
        this.data = data;
        this.lowerNode = lowerNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Nodo<T> getLowerNode() {
        return lowerNode;
    }

    public void setLowerNode(Nodo<T> lowerNode) {
        this.lowerNode = lowerNode;
    }
}
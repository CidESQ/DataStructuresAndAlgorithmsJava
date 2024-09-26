
public class Main {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>(4); // Capacidad inicial de 4

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);

        System.out.println(array); // [1, 2, 3, 4]

        array.add(5); // Aquí el array se redimensiona
        System.out.println(array); // [1, 2, 3, 4, 5]

        array.removeAt(2); // Elimina el valor en la posición 2 (el número 3)
        System.out.println(array); // [1, 2, 4, 5]
    }
}

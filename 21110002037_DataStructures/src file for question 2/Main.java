public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList<String> list = new CircularDoublyLinkedList<>();
        list.addLast("Oğuz");
        list.addLast("Alperen");
        list.addLast("Selda");
        list.addLast("Mustafa");
        list.addLast("Eylül");

        list.displayList();

        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        System.out.println("Removing first element: " + list.removeFirst());
        System.out.println("Removing last element: " + list.removeLast());
        list.displayList();


        list.addFirst("Ali");
        System.out.println("First Element: " + list.get(0));
        list.removeFirst();
        System.out.println("Size of the list: " + list.size());
        System.out.println("Is the list empty? " + list.isEmpty());

        list.insertionSort();

        System.out.println("Sorted list:");
        list.displayList();
    }
}

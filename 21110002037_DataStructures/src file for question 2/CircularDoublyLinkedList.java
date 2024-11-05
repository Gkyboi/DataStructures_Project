public class CircularDoublyLinkedList<D> {
    private Node<D> head;
    private int size;

    private static class Node<D> {
        private D data;
        private Node<D> next;
        private Node<D> prev;

        public Node(D data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void addFirst(D data) { // adds given data item to the beginning of the list
        Node<D> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void addLast(D data) { // Adds the given data item to the end of the list.
        Node<D> newNode = new Node<>(data);

        if (isEmpty()) { // if list is empty it put first node given item
            head = newNode;
            head.next = head;
            head.prev = head;
        } else { // if list is not empty, it goes last section and put data
            newNode.prev = head.prev;
            newNode.next = head;
            head.prev.next = newNode;
            head.prev = newNode;
        }

        size++;
    }

    public D removeFirst() { // Removes and returns the first data item of the list.
        if (isEmpty()) // if list is empty, function does not remove any data. Because of this program will create a exception. This section reduce the exception.
            throw new IllegalStateException("List is empty");

        Node<D> removedNode = head;

        if (size == 1) { // if list size equal to 1, it does equals head data with null data. After this process list will be completely empty.
            head = null;
        } else {
            head.prev.next = head.next;
            head.next.prev = head.prev;
            head = head.next;
        }

        size--; // decrease the size of list after remove first item.
        return removedNode.data;
    }

    public D removeLast() {
        if (isEmpty())
            throw new IllegalStateException("List is empty");

        Node<D> removedNode = head.prev;

        if (size == 1) {
            head = null;
        } else {
            head.prev = removedNode.prev;
            removedNode.prev.next = head;
        }

        size--;
        return removedNode.data;
    }

    public D getFirst() {
        if (isEmpty())
            throw new IllegalStateException("List is empty");

        return head.data; // if we return head, we can get first item.
    }

    public D getLast() {
        if (isEmpty())
            throw new IllegalStateException("List is empty");

        return head.prev.data; // if we return head and prev, we can get last item.
    }

    public void add(int index, D data) {
        if (index < 0 || index > size) // if index is less than 0 or greater than list size, program will create a exception. We can reduce this with throw exception.
            throw new IndexOutOfBoundsException("Invalid index");

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node<D> newNode = new Node<>(data);
        Node<D> current = head;

        for (int i = 0; i < index - 1; i++)
            current = current.next;

        newNode.prev = current;
        newNode.next = current.next;
        current.next.prev = newNode;
        current.next = newNode;

        size++;
    }

    public D remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index");

        if (index == 0)
            return removeFirst();

        if (index == size - 1)
            return removeLast();

        Node<D> current = head;

        for (int i = 0; i < index; i++)
            current = current.next;

        current.prev.next = current.next;
        current.next.prev = current.prev;

        size--;
        return current.data;
    }

    public D get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index");

        Node<D> current = head;

        for (int i = 0; i < index; i++)
            current = current.next;

        return current.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertionSort() {
        if (isEmpty() || size == 1) // if list is empty or size equal to 1, it means that we do not have to sort any item.
            return;

        Node<D> current = head.next;

        while (current != head) {
            Node<D> temp = current;
            D tempData = temp.data;

            while (temp.prev != head && ((Comparable<D>) temp.prev.data).compareTo(tempData) > 0) {
                temp.data = temp.prev.data;
                temp = temp.prev;
            }

            temp.data = tempData;
            current = current.next;
        }
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        Node<D> current = head;

        do {
            System.out.print(current.data + ", ");
            current = current.next;
        } while (current != head);

        System.out.println();
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node<D extends Comparable<D>> {
    D data;
    Node<D> left;
    Node<D> right;

    public Node(D data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTree<D extends Comparable<D>> {
    private Node<D> root;

    // Add method for adding data in list
    public void add(D data) {
        root = addRecursive(root, data);
    }

    private Node<D> addRecursive(Node<D> current, D data) {     // adds a data to the tree with recursive
        if (current == null) {
            return new Node<>(data);
        }

        if (data.compareTo(current.data) < 0) {
            current.left = addRecursive(current.left, data);
        } else if (data.compareTo(current.data) > 0) {
            current.right = addRecursive(current.right, data);
        }

        return current;
    }

    // Removes a data from the tree
    public void remove(D data) {
        root = removeRecursive(root, data);
    }

    private Node<D> removeRecursive(Node<D> current, D data) { // removes a data to the tree with recursive
        if (current == null) {
            return null;
        }

        if (data.compareTo(current.data) == 0) {
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {
                D smallestValue = findSmallestValue(current.right);
                current.data = smallestValue;
                current.right = removeRecursive(current.right, smallestValue);
                return current;
            }
        }

        if (data.compareTo(current.data) < 0) {
            current.left = removeRecursive(current.left, data);
        } else {
            current.right = removeRecursive(current.right, data);
        }

        return current;
    }

    private D findSmallestValue(Node<D> node) {     // Finds the smallest value
        return node.left == null ? node.data : findSmallestValue(node.left);
    }

    public int size() {    // Calculates the how many numbers of data in the tree
        return sizeRecursive(root);
    }

    private int sizeRecursive(Node<D> current) {
        if (current == null) {
            return 0;
        }

        return 1 + sizeRecursive(current.left) + sizeRecursive(current.right);
    }


    public boolean isEmpty() {     // Check if the tree is empty or not with boolean
        return root == null;
    }

    public void traverse() { // Tree traversal method
        traverseBreadthFirst(root);
    }

    private void traverseBreadthFirst(Node<D> root) {
        if (root == null) {
            return;
        }

        Queue<Node<D>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<D> current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public boolean search(D data) {     // Search method for a data item in the tree
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(Node<D> current, D data) { // Recursive search method
        if (current == null) {
            return false;
        }

        if (data.compareTo(current.data) == 0) {
            return true;
        }

        if (data.compareTo(current.data) < 0) {
            return searchRecursive(current.left, data);
        } else {
            return searchRecursive(current.right, data);
        }
    }

    public int height() {     // Calculates the height of the tree
        return heightRecursive(root);
    }

    private int heightRecursive(Node<D> current) {
        if (current == null) {
            return -1;
        }

        int leftHeight = heightRecursive(current.left);
        int rightHeight = heightRecursive(current.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public List<D> sort() {     // puts all the data in the array in ascending order
        List<D> sortedList = new ArrayList<>();
        inorderTraversal(root, sortedList);
        return sortedList;
    }

    private void inorderTraversal(Node<D> current, List<D> sortedList) {
        if (current != null) {
            inorderTraversal(current.left, sortedList);
            sortedList.add(current.data);
            inorderTraversal(current.right, sortedList);
        }
    }
}
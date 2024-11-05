public class Main {
    public static void main(String[] args) {
        BinaryTree<String> tree = new BinaryTree<>();

        tree.add("Alperen");
        tree.add("Oğuz");
        tree.add("Mehmet");
        tree.add("Ahmet");
        tree.add("Ayşe");

        System.out.println("Is tree empty?" + tree.isEmpty());
        System.out.println("Size: " + tree.size());
        System.out.println("Names in ascending order: " + tree.sort());
        System.out.println("Height: " + tree.height());


        System.out.println("Searching for \"Emirhan\"... " + (tree.search("Emirhan") ? "Found!" : "Not found."));
        System.out.println("Searching for \"Emirkan\"... " + (tree.search("Emirkan") ? "Found!" : "Not found."));
        System.out.println("Searching for \"Alperen\"... " + (tree.search("Alperen") ? "Found!" : "Not found."));


        tree.remove("Alperen");
        System.out.println("Removing data item \"Alperen\"... Removed successfully.");

        System.out.println("Names in ascending order after removing Alperen: " + tree.sort());
    }
}

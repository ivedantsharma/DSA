import java.util.Scanner;

public class binarytree {
    public static void main(String[] args) {
//        let height  = h, no of leafes = n, no of nodes= N then for perfect binary tree :
//          no of nodes = 2^(h+1) - 1;
//          leaf nodes = 2^h
//          internal nodes = 2^h - 1
//          min levels = logn + 1
//          min height = log(N+1)
//        leaf nodes = N, then for strict binary tree
//          no of internal nodes = N-1
//          no of leaf nodes = no of leaf nodes +1
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.display();
        tree.prettydisplay();
    }
}
class  BinaryTree {
    public BinaryTree() {

    }
    private static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value= value;
        }
    }
    private Node root;

    public void populate(Scanner scanner) {
        System.out.println("Enter the root Node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }
    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter left of " + node.value);
        boolean left = scanner.nextBoolean();
        if(left) {
            System.out.println("Enter the value of the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }
        System.out.println("Do you want to enter right of " + node.value);
        boolean right = scanner.nextBoolean();
        if(right) {
            System.out.println("Enter the value of the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }
    public void display() {
        display(root, "");
    }
    private void display(Node node, String indent) {
        if(node==null) return;
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }
    public void prettydisplay() {
        prettydisplay(root, 0);
    }
    private void prettydisplay(Node node, int level) {
        if(node == null) return;
        prettydisplay(node.right, level+1);
        if(level != 0) {
            for(int i=0;i<level-1;i++) System.out.print("|\t\t");
            System.out.println("|--------->" + node.value);
        }
        else System.out.println(node.value);
        prettydisplay(node.left, level+1);
    }
}

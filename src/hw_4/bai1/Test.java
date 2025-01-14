package hw_4.bai1;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        LinkedListBinaryTree<Integer, Node<Integer>> tree = new LinkedListBinaryTree<>();
        tree.addRoot(1);
        tree.addLeft(tree.root(),2);
        tree.addRight(tree.root(), 3);
        tree.addLeft(tree.root().getLeft(), 4);
        tree.addRight(tree.root().getLeft(), 5);
        tree.displayTree(tree.root(),0);
    }
}



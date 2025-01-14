package hw_4.bai2;
import hw_4.bai1.*;

public class ExpressionTree<E> extends LinkedListBinaryTree<E, Node<E>> {
    public void preorderPrint(Node<E> p) {

        // root left right
        if (p == null) {
            return;
        }
        System.out.print(p.getElement() + " ");
        preorderPrint(p.getLeft());
        preorderPrint(p.getRight());
    }

    public void postorderPrint(Node<E> p) {

        // left right root
        if (p == null) {
            return;
        }
        postorderPrint(p.getLeft());
        postorderPrint(p.getRight());
        System.out.print(p.getElement() + " ");
    }

    public void inorderPrint(Node<E> p) {

        // left root right
        if (super.numChildren(p) == 0) {
            System.out.print(p.getElement());
            return;
        }
        System.out.print("(");
        inorderPrint(p.getLeft());
        System.out.print(" " + p.getElement() + " ");
        inorderPrint(p.getRight());
        System.out.print(")");
    }
}


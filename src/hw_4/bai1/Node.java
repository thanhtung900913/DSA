package hw_4.bai1;

public class Node<E> {
    private E element;
    private Node<E> parent;
    private Node<E> left;
    private Node<E> right;

    public Node(E element) {
        this.element = element;
    }

    public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
        this.element = element;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getParent() {
        return parent;
    }

    public Node<E> getLeft() {
        return left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }
}

package hw_4.bai1;


import java.util.Random;

public class LinkedListBinaryTree<E, T> implements BinaryTreeInterface<T> {

    private Node<E> root = null;
    private int size = 0;

    public Node<E> addRoot(E element) {
        if (root == null) {
            size++;
        }
        root = new Node<>(element, null, null, null);
        return root;
    }

    public Node<E> addLeft(Node p, E element) {
        if (p == null) {
            return null;
        }
        if (p.getLeft() == null) {
            size++;
        }
        p.setLeft(new Node<>(element, p, null, null));
        return p.getLeft();
    }

    public Node<E> addRight(Node p, E element) {
        if (p == null) {
            return null;
        }
        if (p.getRight() == null) {
            size++;
        }
        p.setRight(new Node(element, p, null, null));
        return p.getRight();
    }

    public void set(Node p, E element) {
        if (p == null) {
            size++;
        }
        p = new Node(element, p.getParent(), null, null);
    }

    @Override
    public T root() {
        return (T) root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int numChildren(T p) {
        Node<E> node = (Node<E>) p;
        if (node == null) return 0;
        int count = 0;
        if (node.getLeft() != null) {
            count++;
        }
        if (node.getRight() != null) {
            count++;
        }
        return count;
    }

    @Override
    public T parent(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.getParent();
    }

    @Override
    public T left(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.getLeft();
    }

    @Override
    public T right(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.getRight();
    }

    @Override
    public T sibling(T p) {
        Node<E> node = (Node<E>) p;
        Node<E> parent = node.getParent();
        if (parent.getLeft() == node && parent.getRight() != null) {
            return (T) parent.getRight();
        } else if (parent.getRight() == node && parent.getLeft() != null) {
            return (T) parent.getLeft();
        }
        return null;
    }
    public void inorder(Node<E> p) {
        // left root right
        if (p == null) {
            return;
        }
        inorder(p.getLeft());
        System.out.print(p.getElement()+ " ");
        inorder(p.getRight());
    }

    public void preorder(Node<E> p) {
        // root left right
        if (p == null) {
            return;
        }
        System.out.print(p.getElement()+" ");
        inorder(p.getLeft());
        inorder(p.getRight());
    }

    public void postorder(Node<E> p) {
        // left right root
        if (p == null) {
            return;
        }
        inorder(p.getLeft());
        inorder(p.getRight());
        System.out.print(p.getElement()+" ");
    }

    public void enterTree(T p) {
        Node<E> node = (Node<E>) p;
        Random random = new Random();
        while (size < 9) {
            addRight(node, (E) Integer.valueOf(random.nextInt(10, 200)));
            addLeft(node, (E) Integer.valueOf(random.nextInt(10, 200)));
            enterTree((T) node.getRight());
            enterTree((T) node.getLeft());
        }

    }

    public void displayTree(Node<E> p, int lv) {
        if (p == null) {
            return;
        }
        displayTree(p.getRight(), lv + 1);
        for (int i = 0; i < lv; i++) {
            System.out.print("\t");
        }
        System.out.println(p.getElement());
        displayTree(p.getLeft(), lv + 1);
    }
}





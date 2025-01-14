package hw_5.bt1;

public class NodeEntry<K, E> implements Entry<K, E> {
    private K key;
    private E element;
    private NodeEntry<K, E> next;

    public NodeEntry() {
    }

    public NodeEntry(K k, E e, NodeEntry<K, E> next) {
        this.next = next;
        this.element = e;
        this.key = k;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public E getValue() {
        return element;
    }

    @Override
    public String toString() {
        return "(" + key + "," + element + ")";
    }

    public void setNext(NodeEntry<K, E> next) {
        this.next = next;
    }

    public NodeEntry<K, E> getNext() {
        return next;
    }

}

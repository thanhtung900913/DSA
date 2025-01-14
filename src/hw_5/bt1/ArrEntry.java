package hw_5.bt1;

public class ArrEntry<K, E> implements Entry<K, E> {
    K key;
    E element;

    public ArrEntry(K k, E e) {
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

    public void setKey(K key) {
        this.key = key;
    }

    public void setElement(E element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "(" + key + "," + element + ")";
    }
}

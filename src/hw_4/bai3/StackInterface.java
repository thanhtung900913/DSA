package hw_4.bai3;

public interface StackInterface<E> extends Iterable<E>{
    public void push(E element);
    public E pop();
    public E top();
    public boolean isEmpty();
}


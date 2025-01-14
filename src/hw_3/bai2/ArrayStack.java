package hw_3.bai2;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
    final int DEFAULTSIZE = 16;
    E[] stack;
    int size;

    public ArrayStack(){
        stack = (E[]) new Object[DEFAULTSIZE];
        size = 0;
    }
    @Override
    public void push(E element) {
        if(size == stack.length){
            enlarge();
        }
        stack[size] = element;
        size++;
    }

    @Override
    public E pop() {
        if(size == 0){
            return null;
        }
        E tmp = stack[size-1];
        stack[size-1] = null;
        size--;
        return tmp;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E top() {
        if(size == 0){
            return null;
        }
        return stack[size-1];
    }
    public void enlarge(){
        E[] arr = (E[]) new Object[stack.length*2];
        System.arraycopy(stack, 0, arr, 0, size);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}

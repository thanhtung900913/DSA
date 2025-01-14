package hw_2.bai2;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    @Override
    public void add(T data) {
        if(size() > defaultSize){
            throw new ArrayIndexOutOfBoundsException();
        }else {
            array[size()] = data;
        }
    }

    @Override
    public T get(int i) {
        return array[i];
    }

    @Override
    public void set(int i, T data) {
        array[i] = data;
    }

    @Override
    public void remove(T data) {
        int idx = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == data){
                idx = i;
            }
        }
        for (int i = idx; i < array.length -1 ; i++) {
            array[i] = array[i+1];
        }
    }

    @Override
    public boolean isContain(T data) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == data){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}

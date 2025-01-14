package hw_3.bai4;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;
    public ArrayQueue(int capacity){
        n = capacity;
        this.queue = (E[]) new Object[capacity];
    }
    @Override
    public void enqueue(E element) {
        if(count == 0){
            queue[0] = element;
        }else {
            for (int i = count-1; i >= 0; i--) {
                queue[i + 1] = queue[i];

            }
            queue[0] = element;
        }
        count++;
    }

    @Override
    public E dequeue() {
        E tmp = queue[count-1];
        queue[count-1] = null;
        count --;
        return tmp;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}

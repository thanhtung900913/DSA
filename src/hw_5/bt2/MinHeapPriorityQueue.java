package hw_5.bt2;
import hw_5.bt1.*;
public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E> {
    ArrEntry<K, E> heapPQ[];
    public MinHeapPriorityQueue(int capacity) {
        this.heapPQ = new ArrEntry[capacity];
        n++;
    }

    @Override
    public int size() {
        return n - 1;
    }

    @Override
    public void insert(Entry<K, E> entry) throws IllegalArgumentException {
        if (n == heapPQ.length) {
            return;

        }
        heapPQ[n++] = (ArrEntry<K, E>) entry;
        upHeap();
    }

    @Override
    public void insert(K k, E e) throws IllegalStateException {
        ArrEntry<K, E> a = new ArrEntry<K, E>(k, e);
        insert(a);
    }

    @Override
    public Entry<K, E> removeMin() {
        swap(1, n - 1);
        ArrEntry<K, E> temp = heapPQ[n - 1];
        heapPQ[n - 1] = null;
        n--;
        downHeap();
        return temp;
    }
    protected void upHeap(){
        int i = n - 1;
        while (i > 1 && (heapPQ[i / 2].getKey().compareTo(heapPQ[i].getKey()) > 0)) {
            swap(i / 2, i);
            i = i / 2;
        }
    }
    protected void downHeap(){
        int i = 1;
        while (i < n) {
            if (2 * i + 1 < n) { // tồn tại cả 2 con
                if (heapPQ[i].getKey().compareTo(heapPQ[2 * i].getKey()) < 0
                        && heapPQ[i].getKey().compareTo(heapPQ[2 * i + 1].getKey()) < 0) {
                    return;
                } else {
                    int min = 2 * i;
                    if (heapPQ[2 * i].getKey().compareTo(heapPQ[2 * i + 1].getKey()) > 0) {
                        min = 2 * i + 1;
                    }
                    if (heapPQ[i].getKey().compareTo(heapPQ[min].getKey()) >= 0) {
                        swap(i, min);
                        i = min;
                    }

                }

            } else { // chỉ có mỗi 1 con hoặc 0 con
                if (2 * i < n) { // có con trái
                    if (heapPQ[i].getKey().compareTo(heapPQ[2 * i].getKey()) > 0) {
                        swap(i, 2 * i);
                        i = 2 * i;
                    }
                }
            }
            return;
        }
    }
    public void swap(int a, int b) {
        ArrEntry<K, E> temp;
        temp = heapPQ[a];
        heapPQ[a] = heapPQ[b];
        heapPQ[b] = temp;
    }

    public void printHeap() {
        for (int i = n-1; i >= 1; i--) {
            System.out.println(heapPQ[i].toString());
        }
    }
}

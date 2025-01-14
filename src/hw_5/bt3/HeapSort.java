package hw_5.bt3;

import java.util.PriorityQueue;

public class HeapSort<K> {
    K key;
    PriorityQueue<K> queue;
    K[] list;

    public HeapSort() {
        this.queue = new PriorityQueue<K>();

    }

    public void insert(K[] inp) {
        for (int i = 0; i < inp.length; i++) {
            queue.add(inp[i]);
        }
    }

    @SuppressWarnings("unchecked")
    public void heapSort() {
        this.list = (K[]) new Object[queue.size()];
        int n = queue.size();
        for (int i = 0; i < n; i++) {
            list[i] = queue.remove(); //remove min rồi gán nó vào list
        }
    }

    public void printList() {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}

package hw_5.bt1;

public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    ArrEntry<K, E> [] array;
    int n = 0;
    int defaultsize = 1000;

    public UnsortedArrayPriorityQueue(){
        array = new ArrEntry[defaultsize];
    }

    public UnsortedArrayPriorityQueue(int capacity) {
        this.array = new ArrEntry[capacity];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry entry) {
        if(n >= defaultsize){
            System.out.println("Queue is full");
            return;
        }
        array[n] = (ArrEntry<K, E>) entry;
        n++;
    }

    @Override
    public void insert(K k, E e) {
        insert(new ArrEntry(k, e));
    }
    // Them ham tim index nho nhat
    public int findMinIndex(){
        int minIndex = 0;
        ArrEntry<K,E> min = array[0]; // gan gtri min
        for(int i = 1; i < n- 1; i++){
            if(min.getKey().compareTo(array[i].getKey()) > 0){
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    @Override
    public Entry removeMin() {
        if(isEmpty()){
            return null;
        }
        int minIndex = findMinIndex();
        ArrEntry<K,E> min = array[minIndex];
        for(int i = 0; i < n; i++){
            if(array[i] == min){
                for(int j = i; j < n; j++){
                    array[j] = array[j+1];
                }
            }
        }
        n--;
        return min;
    }

    @Override
    public Entry min() {
        int minIndex = findMinIndex();
        ArrEntry<K,E> min = array[minIndex];
        return min;
    }
    public void printQueue() {
        for (int i = 0; i < n; i++) {
            System.out.println(array[i].toString());
        }
    }
}

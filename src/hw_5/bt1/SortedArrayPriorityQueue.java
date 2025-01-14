package hw_5.bt1;
public class SortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    ArrEntry<K, E>[] array;
    public int n = 0;
    int defaultsize = 1000;

    public SortedArrayPriorityQueue() {
        array = new ArrEntry[defaultsize];
    }

    public SortedArrayPriorityQueue(int capacity) {
        array = new ArrEntry[capacity];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return (n == 0);
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if(n >= defaultsize){
            System.out.println("Queue is full");
            return;
        }
        ArrEntry<K, E> entryArr = (ArrEntry<K, E>) entry;
        array[n++] = entryArr;
        int curIndex = n - 1;
        for(int i = n - 2; i < array.length; i--){
            ArrEntry<K, E> temp = array[i];
            if(entryArr.getKey().compareTo(temp.getKey()) >= 0){
                ArrEntry<K, E> t = array[i];
                array[curIndex] = array[i];
                array[i] = t;
                curIndex = i;
            }
        }
    }

    @Override
    public void insert(K k, E e) {
        ArrEntry<K, E> entry = new ArrEntry<>(k,e);
        insert(entry);
    }

    @Override
    public Entry<K, E> removeMin() {
        ArrEntry<K, E> min = array[n-1];
        array[--n] = null;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        return array[n - 1];
    }

    public void printQueue() {
        for (int i = n - 1; i >= 0; i--) {
            System.out.println(array[i].toString());
        }
    }
}

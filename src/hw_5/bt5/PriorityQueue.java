package hw_5.bt5;

import hw_5.bt1.*;
import java.time.Duration;
import java.time.LocalDateTime;

public class PriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K,E> {
    public class ArrEntry<K,E> implements Entry<K,E> {
        private K key;
        private E element;
        public ArrEntry(K key, E element) {
            this.key = key;
            this.element = element;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }
    }
    int defaultSize= 1000;
    ArrEntry<K,E> arr [];
    int n = 0;
    public PriorityQueue(){
        arr = new ArrEntry[defaultSize];
    }
    public PriorityQueue(int capacity){
        arr = new ArrEntry[capacity];
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
    public void insert(Entry<K, E> entry) {
        ArrEntry<K,E> arrEntry = (ArrEntry<K, E>) entry;
       if (n == 0){
           arr[0] = arrEntry;
       }else {
           int index = n - 1;
           LocalDateTime first = LocalDateTime.parse((String )arrEntry.key);
           for (int i = 0 ; i < n ;i++) {
               LocalDateTime second = LocalDateTime.parse((String) arr[i].key);
               LocalDateTime end = LocalDateTime.now();
               Duration duration1 = Duration.between(first,end);
               Duration duration2 = Duration.between(second,end);
               if (duration1.compareTo(duration2) > 0){
                   index = i;
                   break;
               }
           }
           if (index == n - 1){
               arr[n] = arrEntry;
           }else {
               System.arraycopy(arr,index , arr, index + 1 , n - index - 1);
               arr[index] = arrEntry;
           }
       }
       n++;
    }

    @Override
    public void insert(K k, E e) {
        ArrEntry<K,E> entry = new ArrEntry<>(k,e);
        insert(entry);
    }

    @Override
    public Entry<K, E> removeMin() {
        ArrEntry<K,E> temp = arr[0];
        System.arraycopy(arr,1, arr , 0 , arr.length - 1);
        n--;
        return temp;
    }

    @Override
    public Entry<K, E> min() {
        arr[0].element = (E) "take off";
        return arr[0];
    }
    public void print(){
        for (int i = 0 ; i < n ; i++) {
            System.out.println(arr[i].getKey() + " " + arr[i].getValue());        }
    }
}


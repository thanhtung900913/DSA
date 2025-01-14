package hw_5.bt1;

public interface PriorityQueueInterface<K, E> {
    public int size();

    public boolean isEmpty();

    public void insert(Entry<K, E> entry); // thêm một entry vào PQ

    public void insert(K k, E e); // thêm một phần tử có key k và giá trị e vào PQ

    public Entry<K, E> removeMin(); // loại một phần tử có giá trị nhỏ nhất

    public Entry<K, E> min(); // trả về phần tử có key min
}

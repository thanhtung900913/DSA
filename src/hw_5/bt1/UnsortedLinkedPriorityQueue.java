package hw_5.bt1;

public class UnsortedLinkedPriorityQueue <K extends  Comparable<K>, E> implements PriorityQueueInterface<K,E>{
    private NodeEntry <K ,E > head ;
    private NodeEntry <K ,E > tail ;
    int n = 0;

    public UnsortedLinkedPriorityQueue() {
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
        NodeEntry<K,E> newNode = (NodeEntry<K, E>) entry;
        if(n == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        n++;
    }

    @Override
    public void insert(K k, E e) { //thêm phần tử có khoá và giá trị vào đuôi
        insert(new NodeEntry<>(k, e, null));
    }

    @Override
    public Entry<K, E> removeMin() {
        if(isEmpty()){
            throw new NullPointerException("Queue is null");
        }
        NodeEntry<K,E> cur = head;
        if(size() == 1){
            head = null;
            tail = null;
            n = 0;
            return cur;
        }
        NodeEntry<K,E> min = head;
        NodeEntry<K, E> preMin = head;
        NodeEntry<K, E> postMin = head;
        while (cur.getNext() != null){
            if(cur.getKey().compareTo(min.getNext().getKey()) < 0){
                preMin = cur;
                min = cur.getNext();
                postMin = min.getNext();
            }
            cur = cur.getNext();
        }
        if(min == head){
            head = head.getNext();
        } else {
            preMin.setNext(postMin);
        }
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if(isEmpty()){
            throw new NullPointerException("Queue is null~");
        }
        NodeEntry<K,E> cur = head;
        NodeEntry<K,E> min = head;
        while (cur.getNext() != null){
            if(min.getKey().compareTo(cur.getNext().getKey()) > 0){
               min = cur.getNext();
            }
            cur = cur.getNext();
        }
        return min;
    }
    public void printLinkQueue() {
        NodeEntry<K, E> temp = head;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.getNext();
        }
    }
}

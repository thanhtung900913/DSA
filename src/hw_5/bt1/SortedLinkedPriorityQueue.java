package hw_5.bt1;

public class SortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
    private NodeEntry<K, E> head; // phần tử đầu
    private NodeEntry<K, E> tail; // phần tử đuôi
    int n = 0;

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) { // kiểm tra size
            return true;
        }
        return false;
    }

    @Override
    public void insert(Entry<K, E> entry){
        NodeEntry<K, E> temp = (NodeEntry<K, E>) entry;
        if (n == 0) {
            head = temp;
            tail = temp;
        } else if (n == 1) {
            if (temp.getKey().compareTo(head.getKey()) >= 0) {
                head.setNext(temp);
                tail = temp;
            } else {
                temp.setNext(head);
                head = temp;
            }
        } else { //1
            if (temp.getKey().compareTo(head.getKey()) < 0) {
                temp.setNext(head);
                head = temp;
            } else {
                NodeEntry<K, E> cur = head;

                while (cur.getNext() != null) {
                    if (cur.getNext().getKey().compareTo(entry.getKey()) > 0) {
                        temp.setNext(cur.getNext());
                        cur.setNext(temp);
                        break;
                    }

                    cur = cur.getNext();
                }
                if (cur == tail) {
                    tail.setNext(temp);
                    tail = temp;
                }
            }
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        NodeEntry<K,E> entry = new NodeEntry<>(k,e, null);
        insert(entry);
    }

    @Override
    public Entry<K, E> removeMin() {
        NodeEntry<K, E> a = head;
        head = head.getNext();
        n--;
        return a;
    }

    @Override
    public Entry<K, E> min() {
        return head;
    }

    public void printLinkQueue() {
        NodeEntry<K, E> temp = head;
        while (temp != null) {
            System.out.print(temp.toString()+" ");
            temp = temp.getNext();
        }
        System.out.println("");
    }
}
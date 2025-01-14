package hw_3.bai4;


import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    class Node{
        E data;
        Node next;
        public Node(E element){
            this.data = element;
            this.next = null;
        }
    }
    private Node queue;
    private Node bot;
    private int size;
    public LinkedListQueue(){
        this.queue = null;
        this.bot = null;
        size = 0;
    }
    @Override
    public void enqueue(E element) {
        Node node = new Node(element);
        if(queue == null){
            queue = bot = node;
        }else {
            bot.next = node;
            bot = node;
        }
        size++;
    }

    @Override
    public E dequeue() {
        E data = queue.data;
        queue = queue.next;
        size--;
        return data;


    }
    public int getSize(){
        return size;
    }
    public Node getEAtI(int i){
        Node tmp = queue;
        int j = 0;
        while (j < i){
            tmp = tmp.next;
            j++;
        }
        return tmp;
    }
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}

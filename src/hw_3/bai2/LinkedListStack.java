package hw_3.bai2;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E>{
    class Node{
        E element;
        Node next;
        public Node(E element){
            this.element = element;
            next = null;
        }
    }
    private Node stack = null;
    private int size = 0;
    @Override
    public void push(E element) {
        Node newNode = new Node(element);
        if(size == 0){
            stack = newNode;
        }else {
            newNode.next = stack;
            stack = newNode;
        }
        size++;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        }else {
            Node tmp = stack;
            stack = stack.next;
            size--;
            return tmp.element;
        }
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public E top() {
        if(size == 0){
            return null;
        }
        return stack.element;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}

package hw_4.bai3;

import java.util.Iterator;

public class Stack<E> implements StackInterface<E>{
    class Node{
        private E element;
        private Node next;

    }
    private Node stack = null;

    @Override
    public void push(E element) {
        Node newNode = new Node();
        newNode.element = element;
        if (stack == null){
            stack = newNode;
        }
        stack.next = newNode;
        stack = newNode;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new IllegalArgumentException("Linked list is empty");
        E element = stack.element;
        stack = stack.next;
        return element;
    }

    @Override
    public E top() {
        if (isEmpty()){
            throw new IllegalArgumentException("Linked list is empty");
        }
        return stack.element;
    }

    @Override
    public boolean isEmpty() {
        return stack == null;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }
    class StackIterator implements Iterator<E>{
        private Node current = stack;

        @Override
        public boolean hasNext() {
            return current == null;
        }

        @Override
        public E next() {
            E element = current.element;
            current = current.next;
            return element;
        }
    }
    public void print(){
        Node current = stack;
        while (current != null){
            System.out.print(current.element+ " ");
            current = current.next;
        }
    }
}

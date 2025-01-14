package practice;

import java.util.Iterator;

public class Basic_Stack {
    public static void main(String[] args) {
        St s = new St();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(5);
        s.push(4);
        s.push(3);
        for(int n: s){
            System.out.println(n+",");
        }
    }
    public static class Node{
        Node next;
        int data;
        public Node(int data){
            this.data = data;
        }
    }
    public static class St implements Iterable<Integer>{
        Node head = null;
        int n;
        public void push(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;
            }else {
                newNode.next = head;
                head = newNode;
            }
            n++;
        }
        public int pop(){
            if(head == null){
                return -1;
            }
            else {
                int data = head.data;
                head = head.next;
                n--;
                return data;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node tmp = head;
            for (int i = 0; i < n; i++) {
                sb.append(tmp.data).append(" ");
                tmp = tmp.next;
            }
            return sb.toString();
        }

        @Override
        public Iterator<Integer> iterator() {
            return new StackIterator();
        }

        public class StackIterator implements Iterator<Integer>{
            Node cur = head;
            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public Integer next() {
                int data = cur.data;
                cur = cur.next;
                return data;
            }
        }
    }

}

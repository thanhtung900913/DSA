package LinkedListProgramming;

public class LinkedListPrograming {
    public static class Node {
        int Data;
        Node next;
        public Node(int Data){
            this.Data = Data;
            this.next = null;
        }
    }
    public static class LinkedList{
        Node head;
        Node tail;
        int size;
        public LinkedList(){
            this.head = null;
            this.tail = null;
            this.size = 0;
        }
        public void add(int Data){
            Node newNode = new Node(Data);
            if(size == 0){
                this.head = newNode;
                this.tail = newNode;
            }else {
                tail.next = newNode;
                this.tail = newNode;
            }
            size++;
        }
        public int get(int i){
            if (i < 0 || i >= size ){
                throw new ArrayIndexOutOfBoundsException();
            }else {
                Node tmp = head;
                int j = 0;
                while (j != i){
                    tmp = tmp.next;
                    j++;
                }
                return tmp.Data;
            }
        }
        public void remove(int i){
            if(i < 0 || i >= size){
                throw new ArrayIndexOutOfBoundsException();
            }else {
                if(i == 0){
                    head = head.next;
                }else {
                    Node prev = elementAt(i-1);
                    prev.next = prev.next.next;
                }
            }
            size--;
        }
        public Node elementAt(int i) {
            if (i < 0 || i >= size) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                Node tmp = head;
                int j = 0;
                while (j != i) {
                    tmp = tmp.next;
                    j++;
                }
                return tmp;
            }
        }

        @Override
        public String toString() {
            String str = "";
            for (int i = 0; i < size; i++) {
                str+= this.get(i)+", ";
            }
            return str;
        }
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.remove(0);
        System.out.println(l1);
    }

}

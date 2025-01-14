package Stack;

public class Stack1 {
    public static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static class Stack{
        Node head;
        int size;
        public Stack(){
            this.head = null;
            size = 0;
        }
        public void push(int data){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            size++;
        }
        public void pop(){
            head = head.next;
            size--;
        }
        public Node peek(){
            return head;
        }
        public boolean isEmpty(){
            return head == null;
        }
        public int size(){
            return size;
        }
        public Node elementAt(int i){
            int j = 0;
            Node tmp = head;
            while (j != i){
                tmp = tmp.next;
                j++;
            }
            return tmp;
        }

        @Override
        public String toString() {
            String str = "";
            for (int i = 0; i < size; i++) {
                str += elementAt(i).data+", ";
            }
            return str;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s);
        s.pop();
        System.out.println(s);
    }
}

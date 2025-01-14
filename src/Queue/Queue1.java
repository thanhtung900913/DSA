package Queue;

public class Queue1 {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static class Queue{
        Node head;
        Node tail;
        int size;
        public Queue(){
            this.head = null;
            this.tail = null;
            this.size = 0;
        }
        public void enqueue(int data){
            Node node = new Node(data);
            if(this.head == null){
                this.head = node;
                this.tail = node;
            }else {
                this.tail.next = node;
                tail = node;
            }
            size++;
        }
        public boolean isEmpty(){
            return size == 0;
        }
        public Node dequeue(){
            Node tmp = head;
            head = head.next;
            size--;
            return tmp;
        }
        public Node peek(){
            return head;
        }
        public Node elementAt(int i){
            int j = 0;
            Node tmp = head;
            while (j != i){
                tmp =  tmp.next;
                j++;
            }
            return tmp;
        }
        public String toString() {
            String str = "";
            for (int i = 0; i < size; i++) {
                str += elementAt(i).data+", ";
            }
            return str;
        }
    }
    public static void main(String[] args) {
        Queue q1 = new Queue();
        q1.enqueue(10);
        q1.enqueue(9);
        q1.enqueue(8);
        q1.enqueue(7);
        System.out.println(q1);
    }

}

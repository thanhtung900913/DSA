package practice;

public class Basic_Queue {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q);
    }
    public static class Node{
        Node next;
        int data;
        public Node(int data){this.data = data;}
    }
    public static class Queue{
        Node top = null;
        Node bot = null;
        int n = 0;
        public void enqueue(int data){
            Node a = new Node(data);
            if(top == null){
                top = a;
                bot = a;
            }else {
                bot.next = a;
                bot = a;
            }
            n++;
        }
        public int dequeue(){
            if(top == null){
                return -1;
            }else {
                int data = top.data;
                top= top.next;
                n--;
                return data;
            }

        }
        public String toString(){
            StringBuilder sb = new StringBuilder();
            Node tmp = top;
            for (int i = 0; i < n; i++) {
                sb.append(tmp.data).append(" ");
                tmp = tmp.next;
            }
            return sb.toString();
        }
    }
}

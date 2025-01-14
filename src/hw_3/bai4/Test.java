package hw_3.bai4;

public class Test {
    public static void main(String[] args) {
//        ArrayQueue<Integer> q = new ArrayQueue<>(100);
//        System.out.println(q.isEmpty());
//        q.enqueue(1);
//        q.enqueue(2);
//        q.enqueue(3);
//        q.enqueue(4);
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());

        LinkedListQueue<Integer> q2 = new LinkedListQueue<>();
        q2.enqueue(1);
        q2.enqueue(2);
        q2.enqueue(3);
        q2.enqueue(4);
        System.out.println(q2.dequeue());
        System.out.println(q2.dequeue());
        System.out.println(q2.dequeue());
        System.out.println(q2.dequeue());
    }
}

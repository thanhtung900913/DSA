package hw_3.bai2;

public class test {
    public static void main(String[] args) {
//        ArrayStack<Integer> s1 = new ArrayStack<>();
//
//        s1.push(1);
//        s1.push(2);
//        s1.push(3);
//        s1.push(4);
//        while (s1.top() != null){
//            System.out.print(s1.pop()+", ");
//        }

        LinkedListStack<Integer> s2 = new LinkedListStack<>();
        s2.push(1);
        s2.push(2);
        s2.push(3);
        s2.push(4);
        while (s2.top() != null){
            System.out.print(s2.pop()+", ");
        }
    }
}

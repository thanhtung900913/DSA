package hw_3.bai5;

import hw_3.bai4.LinkedListQueue;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        LinkedListQueue<Character> q1 = new LinkedListQueue<>();
        LinkedListQueue<Character> q2 = new LinkedListQueue<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap vao chuoi: ");
        String str = scan.nextLine();
        for (int i = 0; i < str.length(); i++) {
            q1.enqueue(str.charAt(i));
        }
        for (int i = str.length()-1; i >= 0; i--) {
            q2.enqueue(str.charAt(i));
        }
        System.out.println(check(q1, q2));
    }
    public static boolean check(LinkedListQueue<Character> q1, LinkedListQueue<Character> q2){
        int i = q1.getSize();
        for (int j = 0; j < i; j++){
            if(q1.dequeue() != q2.dequeue()){
                return false;
            }
        }
        return true;
    }
}

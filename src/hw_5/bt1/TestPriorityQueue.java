package hw_5.bt1;

import java.util.Random;
import java.util.Scanner;

public class TestPriorityQueue {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Test các kiểu dữ liệu Priority Queue!");
        SortedLinkedPriorityQueue<Integer,Integer> priqueue = new SortedLinkedPriorityQueue<>();
        System.out.println("Test danh sách các số nguyên: ");
        System.out.print("Nhập số phần tử có trong mảng: ");
        int n = sc.nextInt();
        Random rd = new Random();
        for(int i = 0; i< n ; i++){
            int k = rd.nextInt()% 100;
            int e = k;
            priqueue.insert(k, e);
        }
        priqueue.printLinkQueue();
        System.out.println("-------------------------------------");
        System.out.println("Test Danh sách các đối tượng có khóa và giá trị khác nhau.");
        SortedLinkedPriorityQueue<Double,String> queue = new SortedLinkedPriorityQueue<>(); //Hàng hoá(Giá trị) , giá tiền(Khoá)
        queue.insert(1000.0, "banhngot");
        queue.insert(1000.0, "keo");
        queue.insert(2000.0, "banhmy");
        queue.insert(1700.0, "mitom");
        queue.insert(3800.0, "nuocngot");
        queue.insert(1070.0, "trachanh");
        queue.insert(300.0, "nuoc");
        queue.printLinkQueue();
    }
}

package hw_5.bt3;

import java.util.Random;
import java.util.*;

public class TestTimeSort {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Tạo mảng để kiểm tra thời gian sắp xếp!");
        System.out.print("Nhập vào số phần tử trong mảng: ");
        int n = scan.nextInt();
        int[] input = new int[n];
        Integer[] inputN = new Integer[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int num = rand.nextInt() % 100;
            input[i] = num;
            inputN[i] = num;
        }
        HeapSort<Integer> heap = new HeapSort<>();
        heap.insert(inputN);
        long time1 = System.currentTimeMillis();
        heap.heapSort();
        long time11 = System.currentTimeMillis();
        long t1 = (time11 - time1)%(10^-3);
        System.out.println("Thời gian chạy của HeapSort: "+ t1 +" (giây)");


        SelectionSort sel = new SelectionSort();
        long time3 = System.currentTimeMillis();
        sel.selectSort(input);
        long time33 = System.currentTimeMillis();
        long t3 = (time33 - time3)%(10^-3);
        System.out.println("Thời gian chạy của SelectSort: "+ t3 +" (giây)");

        QuickSort quick = new QuickSort();
        quick.insert(input);
        long time4 = System.currentTimeMillis();
        quick.sort(0, n-1);
        long time44 = System.currentTimeMillis();
        long t4 = (time44 - time4)%(10^-3);
        System.out.println("Thời gian chạy của quickSort: "+ t4 +" (giây)");
    }
}
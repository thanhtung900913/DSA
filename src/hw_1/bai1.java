package hw_1;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap vao do dai mang");
        int n = scan.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scan.nextInt();
        }
        printArray(insertionSort(arr1));
        int[] arr2 = new int[n];
        Random random = new Random();
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = random.nextInt(10^5);
        }
        printArray(insertionSort(arr2));
    }
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length-1) {
                System.out.println(arr[i]);
            }else {
                System.out.print(arr[i] + " ,");
            }
        }
    }
    // sắp xếp nổi bọt
    public static int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] < arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }
    // Sắp xếp chọn
    public static int[] selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int idx = i;
            int max = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] > max){
                    idx = j;
                    max = arr[j];
                }
            }
            int tmp = arr[i];
            arr[i] = max;
            arr[idx] = tmp;

        }
        return arr;
    }
    // Sắp xếp chèn
    public static int[] insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j = i-1;
            int key = arr[i];
            while (j >= 0 && arr[j]>key){
            arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] =key;
        }
        return arr;
    }

    // Sắp xếp trộn (Merge Sort)
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static int[] merge(int[] array, int left, int middle, int right) {
        int[] leftArray = Arrays.copyOfRange(array, left, middle + 1);
        int[] rightArray = Arrays.copyOfRange(array, middle + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
        return array;
    }

    // Sắp xếp nhanh (Quick Sort)
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[right] = array[i + 1];
        array[i + 1] = pivot;
        System.out.println("Quick Sort sau khi phân đoạn: " + Arrays.toString(array));
        return i + 1;
    }




}

package hw_5.bt2;

public class Test {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> heap = new MinHeapPriorityQueue<>(10);
        heap.insert(7, "i");
        heap.insert(2, "love");
        heap.insert(1, "you");
        heap.insert(4, "when");
        heap.insert(5, "she");
        heap.insert(10, "come");
        heap.insert(15, "my");
        heap.insert(25, "life");

        heap.printHeap();
        System.out.println();
        System.out.println("Heapsize = "+heap.size());
        System.out.println("---------------------------");
        int n = heap.size();
        for (int i = 0; i < n; i++) {

            System.out.println("min= "+ heap.removeMin());
            heap.printHeap();
            System.out.println(" ");
        }
        System.out.println("--------------");
        heap.printHeap();
        System.out.println(" ");
    }
}

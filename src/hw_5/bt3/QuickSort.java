package hw_5.bt3;

public class QuickSort {
    public int[] input;

    public QuickSort() {
    }

    public int partition(int x, int y) {
        int index = (x - 1);
        int value = input[y];

        for (int j = x; j < y; j++) {
            if (input[j] < value) {
                index++;
                int temp = input[index];
                input[index] = input[j];
                input[j] = temp;
            }
        }

        int temp = input[y]; // temp =
        input[y] = input[index + 1];
        input[index + 1] = temp;
        return index + 1;
    }

    public void insert(int[] input) {
        this.input = input;
    }

    public void sort(int a, int b) {
        if (a < b) {
            int p = partition(a, b);
            sort(a, p - 1);
            sort(p + 1, b);
        }
    }

    public void print() {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}

package hw_5.bt3;

public class SelectionSort {
    public int[] selectSort(int[] input) {
        System.out.println(" ");
        int  position =  0 ;

        for  ( int  i =  0 ; i <input.length; i ++) {
            int  j = i +  1 ;
            position = i;
            int  temp = input [i];
            for  (; j <input.length; j ++) {
                if  (input [j] <temp) {
                    temp = input [j];
                    position = j;
                }
            }
            if(temp<input[i]) {
                input [position] = input [i];
                input [i] = temp;
            }
        }
        return input;
    }
}

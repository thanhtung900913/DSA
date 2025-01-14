package practice;

public class test {
    public static void main(String[] args) {
        int[] a = {-2, -1 };
        System.out.println(maxSubArray(a));
    }
    public static int maxSubArray(int[] nums) {
        int[][] value = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            value[i][i] = sum;
            for (int j = i+1; j < nums.length; j++) {
                sum+= nums[j];
                value[i][j] = sum;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(value[i][j]+" ");
            }
            System.out.println();
        }
        int max1 = -1000000000;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if(value[i][j] > max1){
                    max1 = value[i][j];
                }
            }
        }

        return max1;
    }
}

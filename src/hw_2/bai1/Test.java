package hw_2.bai1;

import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao n: ");
        int n = scanner.nextInt();
        Fraction[] fractions = new Fraction[n];
        for(int i = 0; i < n; i++){
            float numerator = random.nextFloat(1, 100);
            float denominator = random.nextFloat(1, 100);
            fractions[i] = new Fraction(numerator, denominator);
        }
        for (int i = 0; i < fractions.length; i++) {
            System.out.println(fractions[i]);
        }
        // phan so thu n
        phanSoThuN(scanner, fractions);
        // tong n phan so
        Fraction sum = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            sum = sum.add(fractions[i]);
        }
        System.out.println("tong n phan so la: "+sum);
        // tong n phan so
        Fraction mini = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            mini = mini.minus(fractions[i]);
        }
        System.out.println("hieu n phan so la: "+mini);
        // tich n phan so
        Fraction mul = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            mul = mul.muti(fractions[i]);
        }
        System.out.println("tich n phan so la: "+sum);
        // tich n phan so
        Fraction divi = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            divi = divi.divi(fractions[i]);
        }
        System.out.println("thuong n phan so la: "+sum);
    }
    public static void phanSoThuN(Scanner scanner, Fraction[] fraction){
        System.out.println("Nhap vao n: ");
        int n = scanner.nextInt();
        System.out.println(fraction[n-1]);
    }

}

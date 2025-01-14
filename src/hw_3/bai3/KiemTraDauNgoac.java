package hw_3.bai3;
import hw_3.bai2.LinkedListStack;

import java.util.Scanner;

public class KiemTraDauNgoac {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Dien vao bieu thuc: ");
        String str = scanner.nextLine();
        System.out.println(HopLe(str));
    }
    public static boolean HopLe(String str){
        LinkedListStack<Character> s = new LinkedListStack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ')'){
                if(s.top() == null){
                    return false;
                }else {
                    s.pop();
                }
            }
            if(str.charAt(i) == '('){
                s.push(str.charAt(i));
            }
        }
        if(s.isEmpty()){
            return true;
        }
        return false;
    }
}

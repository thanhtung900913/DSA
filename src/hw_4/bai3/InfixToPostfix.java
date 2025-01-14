package hw_4.bai3;
import hw_3.bai2.*;
public class InfixToPostfix {
    public static boolean isNumber(String input){
        for (int i = 0 ; i < input.length() ; i++){
            if (!Character.isDigit(input.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public static int priority(String str){
        if (str.equals("+") || str.equals("-")){
            return 1;
        }
        if (str.equals("*") || str.equals("/")){
            return  2;
        }
        return 0;
    }
    public static char associativity(String str){
        if (str.equals("^")){
            return 'R';
        }
        return 'L';
    }
    public static String convert(String [] input){
        StringBuilder stringBuilder = new StringBuilder();
        LinkedListStack<String> linkedListStack = new LinkedListStack<>();
        for (int i = 0 ; i < input.length ; i++){
            String str = input[i];
            if (isNumber(str)){
                stringBuilder.append(str + " ");
            } else if (str.equals("(")){
                linkedListStack.push(str);
            } else if (str.equals(")")){
                while (!linkedListStack.isEmpty() && !linkedListStack.top().equals("(")){
                    stringBuilder.append(linkedListStack.pop() + " ");
                }
                linkedListStack.pop();
            } else {
                while (!linkedListStack.isEmpty() && ((priority(str) <= priority(linkedListStack.top()))  && associativity(str) == 'L')){
                    stringBuilder.append(linkedListStack.pop() + " ");

                }
                linkedListStack.push(str);
            }
        }
        while (!linkedListStack.isEmpty()){
            stringBuilder.append(linkedListStack.pop() + " ");
        }
        return stringBuilder.toString().trim();

    }
}

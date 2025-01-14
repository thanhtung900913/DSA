package hw_3.bai3;

import java.util.Stack;

public class TinhGiaTriBieuThuc {

    public static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    public static int applyOperator(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Không thể chia cho 0");
                }
                return a / b;
        }
        return 0;
    }

    public static int evaluate(String expression) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == ' ') {
                continue;
            }

            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    val = val * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                values.push(val);
                i--;
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    public static void main(String[] args) {
        String expression = "(1 + ((2 + 3) ∗ (8 ∗ 5)))";
        System.out.println("Kết quả: " + evaluate(expression));
    }
}

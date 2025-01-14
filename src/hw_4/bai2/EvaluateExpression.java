package hw_4.bai2;
import hw_4.bai1.Node;

public class EvaluateExpression {
    public static float evaluate(Node<String> e) {
        if (e.getLeft() == null) {
            return Float.parseFloat(e.getElement());
        } else {
            float x = evaluate(e.getLeft());
            float y = evaluate(e.getRight());
            String op = e.getElement();
            switch (op) {
                case "+":
                    return x + y;
                case "-":
                    return x - y;
                case "*":
                    return x * y;
                case "/":
                    return x / y;
                default:
                    return -1;
            }
        }
    }

}

package hw_4.bai3;

import java.util.Scanner;

import hw_4.bai1.LinkedListBinaryTree;
import hw_4.bai1.Node;

public class ExpressionTree {
    private Node<String> root ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] array = input.split(" ");
        String[] infix = InfixToPostfix.convert(array).split(" ");
        ExpressionTree tree = new ExpressionTree(infix);
        tree.printInfix();
    }
    public ExpressionTree(String [] infix){
        Stack<Node<String>> stack = new Stack<>();
        LinkedListBinaryTree<String , Node<String>> tree = new LinkedListBinaryTree<>();
        for (int i = 0 ; i < infix.length ; i++){
            if (infix[i] != "+"|| infix[i] != "-"
                    || infix[i] !="*"|| infix[i] !="/") {
                Node<String> node = new Node<>(infix[i]);
                stack.push(node);
            }
            else {
                Node<String> a = stack.pop();
                Node<String> b = stack.pop();
                Node<String> newNode = new Node<>(infix[i]);
                newNode.setRight(b);
                newNode.setLeft(newNode);
                stack.push(newNode);
            }
        }

    }
    public void printInfix() {
        printInfix(root);
    }

    private void printInfix(Node<String> node) {
        if (node == null) {
            return;
        }
        printInfix(node.getLeft());
        System.out.print(node.getElement());
        printInfix(node.getRight());
    }
}

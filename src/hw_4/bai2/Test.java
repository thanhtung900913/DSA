package hw_4.bai2;
import hw_4.bai1.*;

public class Test {
    public static void main(String[] args) {
        //Test ExpressionTree
        ExpressionTree<Integer> treeP = new ExpressionTree<Integer>();
        LinkedListBinaryTree<Integer, Node<Integer>> tree = new LinkedListBinaryTree<Integer, Node<Integer>>() ;
        System.out.println("Test add tree: ");
        tree.addRoot(1);
        tree.addLeft(tree.root(),2);
        tree.addRight(tree.root(), 3);
        tree.addLeft(tree.root().getLeft(), 4);
        tree.addRight(tree.root().getLeft(), 5);
        treeP.inorderPrint(tree.root());
        System.out.println();
        System.out.println("------------------------------------");

        System.out.println("test Expression by tree: ");
        ExpressionTree<String> treeN = new ExpressionTree<String>();
        LinkedListBinaryTree<String, Node<String>> treeM= new LinkedListBinaryTree<String, Node<String>>();
        treeM.addRoot("*");
        treeM.addLeft(treeM.root(), "-");
        treeM.addRight(treeM.root(), "+");
        treeM.addLeft(treeM.root().getLeft(), "2");
        treeM.addRight(treeM.root().getLeft(), "3");
        treeM.addRight(treeM.root().getRight(), "1");
        treeM.addLeft(treeM.root().getRight(),"2");
        treeN.inorderPrint(treeM.root());
        //Test EvaluateExpression
        ExpressionTree<String> treeN2 = new ExpressionTree<String>();
        LinkedListBinaryTree<String, Node<String>> treeM2 = new LinkedListBinaryTree<String, Node<String>>();
        System.out.println("Test evaluate expression Tree: ");
        treeM.addRoot("*");
        treeM.addLeft(treeM2.root(), "-");
        treeM.addRight(treeM2.root(), "+");
        treeM.addLeft(treeM2.root().getLeft(), "20");
        treeM.addRight(treeM2.root().getLeft(), "3");
        treeM.addRight(treeM2.root().getRight(), "1");
        treeM.addLeft(treeM2.root().getRight(), "2");
        treeN.inorderPrint(treeM2.root());
        System.out.println();
        System.out.println("result evaluate expression: "+ EvaluateExpression.evaluate(treeM2.root()));
    }
}

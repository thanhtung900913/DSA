package practice;

import java.util.LinkedList;
import java.util.Queue;

public class Basic_Tree {
    public static void main(String[] args) {
        Tree t = new Tree();
        t.addRoot(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        t.root.setRight(a);
        t.root.setLeft(b);
        TreeNode c = new TreeNode(4);
        t.insertLeft(a, 4);
        t.insertRight(a, 5);

        System.out.print("Pre-Order Traversal: ");
        t.preOrder(t.root);
        System.out.println();

        System.out.print("In-Order Traversal: ");
        t.inOrder(t.root);
        System.out.println();

        System.out.print("Post-Order Traversal: ");
        t.postOrder(t.root);
        System.out.println();

        System.out.print("Level-Order Traversal: ");
        t.levelOrder(t.root);
        System.out.println();
    }

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public int getData() {
            return data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public static class Tree {
        TreeNode root = null;
        int n = 0;

        public TreeNode addRoot(int data) {
            if(root == null){
                this.root = new TreeNode(data);
                n++;
            }
            return this.root;
        }

        public TreeNode insertLeft(TreeNode p, int data) {
            TreeNode tmp = new TreeNode(data);
            if(p == null){
                return null;
            }
            if(p.getLeft() == null){
                n++;
                p.setLeft(tmp);
            }
            return p.getLeft();
        }

        public TreeNode insertRight(TreeNode p, int data) {
            if (p == null) {
                return null;
            }
            if (p.getRight() == null) {
                n++;
            }
            p.setRight(new TreeNode(data));
            return p.getRight();
        }

        public void preOrder(TreeNode root) {
            if(root != null){
                System.out.print(root.getData()+", ");
                preOrder(root.getLeft());
                preOrder(root.getRight());
            }
        }

        public void inOrder(TreeNode root) {
            if(root != null){
                inOrder(root.getLeft());
                System.out.print(root.getData()+", ");
                inOrder(root.getRight());
            }
        }

        // Phương thức duyệt sau (Post-Order)
        public void postOrder(TreeNode root) {
            if(root != null){
                postOrder(root.getLeft());
                postOrder(root.getRight());
                System.out.print(root.getData()+", ");
            }

        }

        // Phương thức duyệt theo level (Level-Order)
        public void levelOrder(TreeNode root) {
            if(root == null){
                return;
            }
            Queue<TreeNode> q= new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()){
                TreeNode cur = q.poll();
                System.out.print(cur.getData()+", ");
                if(cur.getLeft() != null){
                    q.add(cur.getLeft());
                }
                if(cur.getRight() != null){
                    q.add(cur.getRight());
                }
            }
        }
    }
}

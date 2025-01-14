package hw_4.bai1;

public class ArrayBinaryTree<E,T> implements BinaryTreeInterface<T> {
    private E[] array;
    private int n = 0;
    private int defaultsize = 100;

    public ArrayBinaryTree(){
        array = (E[]) new Object[defaultsize];
    }
    public void setRoot(E element){
        array[0] = element;
        n++;
    }
    public void setLeft(int p, E element) {
        if (p < 0) {
            System.out.println("p>=0");
            return;
        }
        if (2 * p + 1 >= array.length) {
            System.out.println("Out index!");
            return;
        }
        if (array[p] == null) {
            System.out.println("No root ");
            return;
        }
        if (array[2 * p + 1] == null) {
            n++;
        }
        array[(2 * p + 1)] = element;
    }

    public void setRight(int p, E element) {
        if (p < 0) {
            System.out.println("p>=0");
            return;
        }
        if (2 * p + 2 >= array.length) {
            System.out.println("Out index!");
            return;
        }
        if (array[p] == null) {
            System.out.println("No root ");
            return;
        }
        if (array[(2 * p) + 2] == null) {
            n++;
        }
        array[(2 * p) + 2] = element;
    }

    @Override
    public T root() {
        if(n > 0){
            return (T) array[0];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(T p) {
        int i = (int) p;
        if(array[2 * i + 1] != null && array[2 * i +2] != null){
            return 2;
        } else if(array[2 * i + 1] == null && array[2 * i +2] == null){
            return 0;
        } else {
            return  1;
        }
    }

    @Override
    public T parent(T p) {
        int i = (int) p;
        if (i < 2) {
            System.out.println("chỉ tìm được parent khi p>2");
            return null;
        }
        if (array[i] == null) {
            return null;
        } else {
            T parent = (T) array[(i - 1)/2];
            return parent;
        }
    }

    @Override
    public T left(T p) {
        int i = (int) p;
        if (i < 0 || i >= array.length) {
            System.out.println("Chỉ tìm được left khi p >= 0");
            return null;
        } else if (array[i] == null || array[2 * i + 1] == null){
            return  null;
        } else {
            T left = (T) array[i*2 + 1];
            return left;
        }

    }

    @Override
    public T right(T p) {
        int i = (int) p;
        if (i < 0 || i >= array.length) {
            System.out.println("Chỉ tìm được right khi p >= 0");
            return null;
        } else if(array[i] == null || array[2*i + 2] == null) {
            return null;
        } else {
            T right = (T) array[i*2 + 2];
            return right;
        }
    }

    @Override
    public T sibling(T p) {
        int i = (int) p;
        if (i < 0 || i >= array.length) {
            System.out.println("Chỉ tìm được sibling khi p >= 0");
            return null;
        }
        int parentIndex = (i - 1) / 2;
        if (parentIndex < 0 || parentIndex >= array.length || array[parentIndex] == null) {
            System.out.println("Không có parent cho p");
            return null;
        }
        if (i % 2 == 0) { // p is a right child
            if (array[parentIndex * 2 + 1] == null) {
                return null;
            } else {
                return (T) array[parentIndex * 2 + 1];
            }
        } else { // p is a left child
            if (array[parentIndex * 2 + 2] == null) {
                return null;
            } else {
                return (T) array[parentIndex * 2 + 2];
            }
        }
    }
    public void inorder(int p) {
        // left root right
        if (array[p] == null) {
            return;
        }
        inorder(2 * p + 1);
        System.out.print(array[p] + " ");
        inorder(2 * p + 2);
    }

    public void preorder(int p) {
        // root left right
        if(array[p] == null) {
            return;
        }
        System.out.print(array[p]+" ");
        preorder(2*p+1);
        preorder(2*p+2);
    }
    public void postorder(int p) {
        // left right root
        if(array[p]== null) {
            return;
        }
        postorder(2*p + 1);
        postorder(2*p+ 2);
        System.out.print(array[p]+ " ");
    }
    public void displayTree(int p){
        int a = size()/2;
        int lv=0;
        // System.out.print('\t');
        // System.out.print(array[1]); //root
        System.out.println();
        for(int i= 1 ; i< size()+1; i++){
            if(i%2==0){
                a--;
            }
            if(i%2!=0){
                a=a+2;
                lv++;
            }
            for(int j=0;j< a;j++){
                System.out.print('\t');
            }
            System.out.println(array[i]);
            if(lv>1){
                a=a-2;
            }
        }
    }
    public void printTree(int p){
        for(int i= 1; i< size()+1; i++){
            System.out.print(array[i]+" ");
        }
    }

}



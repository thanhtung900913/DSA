package hw_2.bai3;

public class SimpleLinkList<T> {
    class Node{
        T data;
        Node next;

    }
    private Node top = null;
    private Node bot = null;
    private int n = 0;
    public void add(T data){
        Node newNode = new Node();
        if(top == null){
            top = newNode;
        }else {
            bot.next = newNode;
        }
        bot = newNode;
        n++;
    }
    public T get(int i){
        if(i > n){
            return null;
        }else {
            Node tmp = top;
            int count = 1;
            while (count != i){
                tmp = tmp.next;
                count++;
            }
            return tmp.data;
        }
    }
    public void set(int i, T data){
        if(i > n){
            throw new ArrayIndexOutOfBoundsException();
        }else {
            Node tmp = top;
            int count = 1;
            while (count != i){
                tmp = tmp.next;
                count++;
            }
            tmp.data = data;
        }
    }
    public boolean isContain(T data){
        Node tmp = top;
        while (tmp.next != null){
            if(tmp.data == data){
                return true;
            }else {
                tmp = tmp.next;
            }
        }
        return false;
    }
    public int size(){
        if(top == null){
            return 0;
        }else {
            Node tmp = top;
            int count = 1;
            while (tmp.next != null){
                tmp = tmp.next;
                count++;
            }
            return count;
        }
    }
    public boolean isEmpty(){
        if(n == 0){
            return false;
        }else {
        return false;
        }
    }
    public T removeTop(){
        if(top == null){
            return null;
        }else {
            Node tmp = top;
            top = top.next;
            n--;
            return tmp.data;
        }

    }
    public T removeBot(){
        if(bot == null){
            return null;
        }else{
            Node tmp = bot;
            Node tmp1 = top;
            while (tmp1.next.next != bot){
                tmp1=tmp1.next;
            }
            tmp1.next = null;
            bot = tmp1;
            return tmp.data;
        }
    }
    public void remove(T data){
        if (n == 0) {
            return;
        }
        if (top.data.equals(data)) {
            removeTop();
            return ;
        }
        Node prev = top;
        Node cur = top.next;

        while (cur != null) {
            if (cur.data.equals(data)) {
                if (cur == bot) {
                    removeBot();
                } else {
                    prev.next = cur.next;
                }
                return;
            }
            prev = cur;
            cur = cur.next;
        }

    }

}

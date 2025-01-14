package hw_5.bt5;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<String , String> tackOff = new PriorityQueue<>();
        tackOff.insert("2024-01-28T12:00:00", "wating");
        tackOff.insert("2024-01-28T12:30:00","wating");
        tackOff.insert("2024-01-28T13:00:00","wating");
        tackOff.insert("2024-01-28T13:30:00","wating");
        tackOff.print();
        System.out.println();
        System.out.println(tackOff.min().getKey() + " : " + tackOff.min().getValue());
        System.out.println();
        tackOff.removeMin();
        tackOff.print();
    }
}
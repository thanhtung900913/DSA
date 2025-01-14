package hash_table;
import java.util.ArrayList;
import java.util.List;

public class Linear_HashTable<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V>[] table;
    private int capacity;
    private int size;

    // Constructor
    public Linear_HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        createTable();
    }

    // Create an initially empty table
    @SuppressWarnings("unchecked")
    public void createTable() {
        table = new Entry[capacity];
    }

    // Hash function
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Linear probing to find the next available index
    private int findSlot(int h, K k) {
        int index = h;
        while (table[index] != null && !table[index].key.equals(k)) {
            index = (index + 1) % capacity;
        }
        return index;
    }

    // Get value for a key in a specific bucket
    public V bucketGet(int h, K k) {
        int index = findSlot(h, k);
        if (table[index] != null && table[index].key.equals(k)) {
            return table[index].value;
        }
        return null;
    }

    // Put a key-value pair in a specific bucket
    public V bucketPut(int h, K k, V v) {
        int index = findSlot(h, k);
        if (table[index] == null) {
            table[index] = new Entry<>(k, v);
            size++;
            return null;
        } else if (table[index].key.equals(k)) {
            V oldValue = table[index].value;
            table[index].value = v;
            return oldValue;
        }
        return null;
    }

    // Remove a key from a specific bucket
    public V bucketRemove(int h, K k) {
        int index = findSlot(h, k);
        if (table[index] != null && table[index].key.equals(k)) {
            V oldValue = table[index].value;
            table[index] = null;
            size--;

            // Rehash subsequent entries to maintain cluster integrity
            int nextIndex = (index + 1) % capacity;
            while (table[nextIndex] != null) {
                Entry<K, V> entryToRehash = table[nextIndex];
                table[nextIndex] = null;
                size--;
                bucketPut(hash(entryToRehash.key), entryToRehash.key, entryToRehash.value);
                nextIndex = (nextIndex + 1) % capacity;
            }

            return oldValue;
        }
        return null;
    }

    // Iterate through all entries in the table
    public Iterable<Entry<K, V>> entrySet() {
        List<Entry<K, V>> entries = new ArrayList<>();
        for(Entry<K, V> e : table){
            if(e != null){
                entries.add(e);
            }
        }
        return entries;
    }

    // Get size of the table
    public int size() {
        return size;
    }

    // Check if the table is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Test the HashTable implementation
    public static void main(String[] args) {
        Linear_HashTable<String, Integer> hashTable = new Linear_HashTable<>(10);

        // Test bucketPut
        int hash1 = hashTable.hash("key1");
        hashTable.bucketPut(hash1, "key1", 10);

        int hash2 = hashTable.hash("key2");
        hashTable.bucketPut(hash2, "key2", 20);

        // Test bucketGet
        System.out.println("Value for key1: " + hashTable.bucketGet(hash1, "key1")); // 10
        System.out.println("Value for key2: " + hashTable.bucketGet(hash2, "key2")); // 20

        // Test bucketRemove
        hashTable.bucketRemove(hash1, "key1");
        System.out.println("Value for key1 after removal: " + hashTable.bucketGet(hash1, "key1")); // null

        // Test entrySet
        for (Entry<String, Integer> entry : hashTable.entrySet()) {
            System.out.println(entry.key + ": " + entry.value);
        }
    }
}

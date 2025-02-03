package hashmapsandhashfunctions.myhashmap;

public class Main {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 10);
        hashMap.put(2, 20);
        hashMap.put(3, 30);

        System.out.println(hashMap.get(2)); // Output: 20
        System.out.println(hashMap.get(4)); // Output: -1 (not found)

        hashMap.put(2, 50); // Update value for key 2
        System.out.println(hashMap.get(2)); // Output: 50

        hashMap.remove(2);
        System.out.println(hashMap.get(2)); // Output: -1 (removed)
    }
}

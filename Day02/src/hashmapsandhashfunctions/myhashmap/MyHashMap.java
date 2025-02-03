package hashmapsandhashfunctions.myhashmap;

class MyHashMap {
    private static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private static final int SIZE = 1000; // Fixed array size
    private Node[] map;

    public MyHashMap() {
        map = new Node[SIZE]; // Initialize array of linked lists
    }

    private int hash(int key) {
        return key % SIZE; // Simple modulo hash function
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (map[index] == null) {
            map[index] = new Node(key, value);
        } else {
            Node prev = null, curr = map[index];
            while (curr != null) {
                if (curr.key == key) {
                    curr.value = value; // Update existing key
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
            prev.next = new Node(key, value); // Insert at end of chain
        }
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = map[index];
        while (curr != null) {
            if (curr.key == key) {
                return curr.value; // Found key
            }
            curr = curr.next;
        }
        return -1; // Not found
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = map[index], prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    map[index] = curr.next; // Remove head node
                } else {
                    prev.next = curr.next; // Remove middle or last node
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

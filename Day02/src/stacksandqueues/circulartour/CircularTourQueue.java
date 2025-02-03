package stacksandqueues.circulartour;

import java.util.LinkedList;
import java.util.Queue;

public class CircularTourQueue {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        Queue<Integer> queue = new LinkedList<>();
        int current_petrol = 0;
        int front = 0; // Start index

        for (int i = 0; i < n; i++) {
            int balance = petrol[i] - distance[i];
            current_petrol += balance;
            queue.add(i);  // Enqueue current pump

            // If at any point fuel is negative, remove front
            while (current_petrol < 0 && !queue.isEmpty()) {
                int removed = queue.poll(); // Dequeue front
                current_petrol -= petrol[removed] - distance[removed]; // Adjust fuel
                front = removed + 1; // Move start index to next
            }
        }

        // Check if total fuel is enough for a full round
        int total_petrol = 0, total_distance = 0;
        for (int i = 0; i < n; i++) {
            total_petrol += petrol[i];
            total_distance += distance[i];
        }

        return (total_petrol >= total_distance) ? front : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startIndex = findStartingPoint(petrol, distance);
        System.out.println("Starting Petrol Pump Index: " + startIndex);
    }
}

package searchtargetinlargedataset;

import java.util.Arrays;
import java.util.Random;

public class SearchTargetInLargeDataset {
    public static void main(String[] args) {
        Random rm = new Random();
        int[] datasets = {1000, 10000, 1000000};

        for (int n : datasets) {
            int[] data = new int[n];

            // Fill array with random numbers
            for (int i = 0; i < n; i++) {
                data[i] = rm.nextInt(n * 10);
            }

            // Pick a target from the dataset to ensure it's present
            int target = data[rm.nextInt(n)];

            // Measure Linear Search Time
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println("Dataset Size: " + n);
            System.out.println("Linear Search Time: " + (totalTime / 1_000_000.0) + " ms");

            // Sort the data for Binary Search
            Arrays.sort(data);

            // Measure Binary Search Time
            startTime = System.nanoTime();
            binarySearch(data, target);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            System.out.println("Binary Search Time: " + (totalTime / 1_000_000.0) + " ms");
            System.out.println();
        }
    }

    static void linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return;
            }
        }
    }

    static void binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
}

package sortingalgorithms.heapsort;

import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Step 1: Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Step 2: Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap root (largest element) with the last element
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Heapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Function to heapify a subtree rooted at index 'i'
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;  // Assume root is the largest
        int left = 2 * i + 1;  // Left child index
        int right = 2 * i + 2; // Right child index

        // Check if left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if right child is larger than the largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If the largest element is not the root, swap and heapify again
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] salaries = {50000, 70000, 40000, 90000, 60000, 80000};

        System.out.println("Original Salaries: " + Arrays.toString(salaries));
        heapSort(salaries);
        System.out.println("Sorted Salaries: " + Arrays.toString(salaries));
    }
}

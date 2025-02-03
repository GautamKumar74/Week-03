package sortingalgorithms.selectionsort;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] scores = {85, 72, 90, 60, 88, 76};

        System.out.println("Original Scores: " + Arrays.toString(scores));
        selectionSort(scores);
        System.out.println("Sorted Scores: " + Arrays.toString(scores));
    }
}

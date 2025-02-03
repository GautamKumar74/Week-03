package sortingalgorithms.countingsort;

import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Step 1: Count occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Compute cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements in sorted order
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy sorted elements back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 14, 10, 18, 15, 10, 12, 17, 16, 14};
        int minAge = 10, maxAge = 18;

        System.out.println("Original Ages: " + Arrays.toString(studentAges));
        countingSort(studentAges, minAge, maxAge);
        System.out.println("Sorted Ages: " + Arrays.toString(studentAges));
    }
}

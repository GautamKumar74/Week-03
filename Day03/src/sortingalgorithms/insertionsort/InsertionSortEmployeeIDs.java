package sortingalgorithms.insertionsort;

import java.util.Scanner;

public class InsertionSortEmployeeIDs {

    // Method to perform Insertion Sort
    public static void insertionSort(int[] ids) {
        int n = ids.length;

        for (int i = 1; i < n; i++) {
            int key = ids[i]; // Current element to be placed in the sorted part
            int j = i - 1;

            // Move elements of the sorted part that are greater than key to one position ahead
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key; // Insert the key at its correct position
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of employees
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        int[] ids = new int[n];

        // Input: Employee IDs
        System.out.println("Enter the Employee IDs:");
        for (int i = 0; i < n; i++) {
            ids[i] = sc.nextInt();
        }

        // Sorting the IDs using Insertion Sort
        insertionSort(ids);

        // Output: Sorted Employee IDs
        System.out.println("Sorted Employee IDs in ascending order:");
        for (int id : ids) {
            System.out.print(id + " ");
        }

        sc.close();
    }
}

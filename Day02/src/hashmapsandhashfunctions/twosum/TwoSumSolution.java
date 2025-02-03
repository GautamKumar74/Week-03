package hashmapsandhashfunctions.twosum;

import java.util.HashMap;
import java.util.Scanner;

public class TwoSumSolution {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // What number do we need?

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // Found the pair
            }

            map.put(nums[i], i); // Store current element in the map
        }

        return new int[]{}; // No pair found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input target sum
        System.out.print("Enter the target sum: ");
        int target = sc.nextInt();

        // Find two sum
        int[] result = twoSum(nums, target);

        // Print result
        if (result.length == 2) {
            System.out.println("Indices of the two numbers: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No pair found that adds up to the target sum.");
        }

        sc.close();
    }
}

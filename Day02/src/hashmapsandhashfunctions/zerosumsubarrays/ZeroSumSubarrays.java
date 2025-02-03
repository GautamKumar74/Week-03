package hashmapsandhashfunctions.zerosumsubarrays;

import java.util.*;

public class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> prefixSumMap = new HashMap<>();
        int sum = 0;

        // Initialize sum = 0 at index -1 to handle subarrays starting from index 0
        prefixSumMap.put(0, new ArrayList<>());
        prefixSumMap.get(0).add(-1);

        // Iterate through array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum exists, get all indices where this sum occurred before
            if (prefixSumMap.containsKey(sum)) {
                for (int startIndex : prefixSumMap.get(sum)) {
                    result.add(new int[]{startIndex + 1, i});  // Store subarray indices
                }
            }

            // Store current index in the HashMap for future subarrays
            prefixSumMap.putIfAbsent(sum, new ArrayList<>());
            prefixSumMap.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Zero-Sum Subarrays:");
        for (int[] subarray : subarrays) {
            System.out.println(Arrays.toString(subarray));
        }
    }
}

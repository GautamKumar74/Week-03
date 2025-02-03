package hashmapsandhashfunctions.pairwithgivensum;

import java.util.*;

public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                System.out.println("Pair Found: (" + num + ", " + complement + ")");
                return true;
            }
            set.add(num);
        }

        System.out.println("No Pair Found");
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        hasPairWithSum(arr, target);
    }
}

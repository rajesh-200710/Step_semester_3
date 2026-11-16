package main.java.week_9_problems.class_problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem4_PairWithTargetSumArray {

    /**
     * Approach 1: Hash Set (Optimal O(N) Time, O(N) Space)
     */
    public static boolean hasPairWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    /**
     * Approach 2: Sort + Two Pointers (O(N log N) Time, O(1) or O(N) Space depending on sorting)
     *
     * Sorts a copy of the array and uses two pointers at the ends to find target sum.
     */
    public static boolean hasPairWithSumSorting(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        // Clone so original array is not modified
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums); // O(N log N)

        int left = 0;
        int right = sortedNums.length - 1;

        while (left < right) {
            int currentSum = sortedNums[left] + sortedNums[right];
            if (currentSum == target) {
                return true;
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Sample 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("--- Problem 4 Test Cases ---");
        System.out.println("Sample 1 (HashSet):      " + hasPairWithSum(nums1, target1));        // true
        System.out.println("Sample 1 (Sorting+2Ptr): " + hasPairWithSumSorting(nums1, target1)); // true

        // Sample 2
        int[] nums2 = {3, 4, 6};
        int target2 = 20;
        System.out.println("Sample 2 (HashSet):      " + hasPairWithSum(nums2, target2));        // false
        System.out.println("Sample 2 (Sorting+2Ptr): " + hasPairWithSumSorting(nums2, target2)); // false
    }
}

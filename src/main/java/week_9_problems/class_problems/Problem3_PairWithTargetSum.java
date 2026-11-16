package main.java.week_9_problems.class_problems;

import java.util.HashSet;
import java.util.Set;

public class Problem3_PairWithTargetSum {

    /**
     * Optimal Approach: Hash Set
     * Time Complexity: O(N) average time complexity
     * Space Complexity: O(N) auxiliary space
     *
     * Iterates through the array and checks if the complement (target - num)
     * already exists in the set of visited numbers.
     */
    public static boolean hasPairWithSumHashSet(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (visited.contains(complement)) {
                return true;
            }
            visited.add(num);
        }
        return false;
    }

    /**
     * Alternative Approach: Brute Force
     * Time Complexity: O(N^2)
     * Space Complexity: O(1) auxiliary space
     *
     * Checks all possible pairs of elements using nested loops.
     */
    public static boolean hasPairWithSumBruteForce(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("--- Problem 3 Test Cases ---");
        System.out.println("Example 1 (Optimal HashSet): " + hasPairWithSumHashSet(nums1, target1)); // true
        System.out.println("Example 1 (Brute Force):    " + hasPairWithSumBruteForce(nums1, target1)); // true

        // Example 2
        int[] nums2 = {3, 4, 6};
        int target2 = 20;
        System.out.println("Example 2 (Optimal HashSet): " + hasPairWithSumHashSet(nums2, target2)); // false
        System.out.println("Example 2 (Brute Force):    " + hasPairWithSumBruteForce(nums2, target2)); // false
    }
}

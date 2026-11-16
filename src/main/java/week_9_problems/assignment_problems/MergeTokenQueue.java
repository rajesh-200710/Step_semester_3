package main.java.week_9_problems.assignment_problems;

import java.util.Arrays;

public class MergeTokenQueue {

    /**
     * Merges two pre-sorted lists of tokens into a single sorted list using two pointers.
     */
    public static int[] mergeTokens(int[] counterA, int[] counterB) {
        int m = counterA.length;
        int n = counterB.length;
        int[] merged = new int[m + n];

        int i = 0, j = 0, k = 0;

        // Two-pointer merge strategy
        while (i < m && j < n) {
            if (counterA[i] <= counterB[j]) {
                merged[k++] = counterA[i++];
            } else {
                merged[k++] = counterB[j++];
            }
        }

        // Copy remaining elements from counterA, if any
        while (i < m) {
            merged[k++] = counterA[i++];
        }

        // Copy remaining elements from counterB, if any
        while (j < n) {
            merged[k++] = counterB[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        // Sample 1
        int[] a1 = {3, 8, 15, 20};
        int[] b1 = {5, 8, 12};
        System.out.println(Arrays.toString(mergeTokens(a1, b1))); // [3, 5, 8, 8, 12, 15, 20]

        // Sample 2
        int[] a2 = {};
        int[] b2 = {4, 9};
        System.out.println(Arrays.toString(mergeTokens(a2, b2))); // [4, 9]
    }
}

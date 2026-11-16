package main.java.week_11_problems.assignment_problems;

import java.util.Arrays;

public class Problem3_AttendanceDisorderScore {

    /**
     * Counts the total number of disorder (inversion) pairs in the roll array.
     * A disorder pair is a pair (i, j) where i < j but roll[i] > roll[j].
     *
     * @param roll The array of student roll numbers.
     * @return The total count of inversion pairs as a long.
     */
    public static long countInversions(int[] roll) {
        if (roll == null || roll.length <= 1) {
            return 0;
        }

        // Clone array if we want to avoid mutating the original input array
        int[] arr = roll.clone();
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    /**
     * Recursive function that divides the array, counts inversions in left and right
     * halves, and adds inversions found during the merge step.
     */
    private static long mergeSortAndCount(int[] arr, int left, int right) {
        long count = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            // Inversions in left half
            count += mergeSortAndCount(arr, left, mid);
            // Inversions in right half
            count += mergeSortAndCount(arr, mid + 1, right);
            // Cross inversions during merge step
            count += mergeAndCount(arr, left, mid, right);
        }

        return count;
    }

    /**
     * Merges two sorted subarrays and counts cross inversions.
     */
    private static long mergeAndCount(int[] arr, int left, int mid, int right) {
        // Create left and right temp arrays
        int leftLen = mid - left + 1;
        int rightLen = right - mid;

        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];

        for (int i = 0; i < leftLen; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < rightLen; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        long swaps = 0;

        while (i < leftLen && j < rightLen) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                // When right elements are smaller, an inversion occurs.
                // It forms a disorder pair with ALL remaining elements in the left half.
                arr[k++] = rightArr[j++];
                swaps += (leftLen - i);
            }
        }

        // Copy remaining elements of leftArr, if any
        while (i < leftLen) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements of rightArr, if any
        while (j < rightLen) {
            arr[k++] = rightArr[j++];
        }

        return swaps;
    }

    public static void main(String[] args) {
        // Sample 1
        int[] roll1 = {2, 4, 1, 3, 5};
        System.out.println("Input 1:  " + Arrays.toString(roll1));
        System.out.println("Disorder Score: " + countInversions(roll1)); // Expected Output: 3

        System.out.println();

        // Sample 2
        int[] roll2 = {5, 4, 3, 2, 1};
        System.out.println("Input 2:  " + Arrays.toString(roll2));
        System.out.println("Disorder Score: " + countInversions(roll2)); // Expected Output: 10
    }
}

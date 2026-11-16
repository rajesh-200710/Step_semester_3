package main.java.week_11_problems.assignment_problems;

import java.util.Arrays;

public class Problem4_PlacementCutoff {

    /**
     * Finds the k-th highest mark using the QuickSelect algorithm.
     *
     * @param marks Array of aptitude marks.
     * @param k The rank of highest mark required (1 <= k <= marks.length).
     * @return The k-th highest mark value.
     */
    public static int kthHighest(int[] marks, int k) {
        if (marks == null || k < 1 || k > marks.length) {
            throw new IllegalArgumentException("Invalid input values");
        }

        int n = marks.length;
        // In an ascending sorted array, the k-th highest element is at index (n - k)
        int targetIndex = n - k;

        int low = 0;
        int high = n - 1;

        // Iterative QuickSelect loop
        while (low <= high) {
            int pivotIndex = partition(marks, low, high);

            if (pivotIndex == targetIndex) {
                return marks[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                // Target lies in the right partition
                low = pivotIndex + 1;
            } else {
                // Target lies in the left partition
                high = pivotIndex - 1;
            }
        }

        return -1;
    }

    /**
     * Partition function using Lomuto scheme with the last element as pivot.
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Place pivot in its correct sorted position
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Sample 1
        int[] marks1 = {72, 95, 60, 88, 79};
        int k1 = 2;
        System.out.println("Sample 1 Input:  " + Arrays.toString(marks1) + ", k = " + k1);
        System.out.println("Expected Output: 88");
        System.out.println("Actual Output:   " + kthHighest(marks1.clone(), k1));

        System.out.println();

        // Sample 2
        int[] marks2 = {50, 90, 90, 70};
        int k2 = 2;
        System.out.println("Sample 2 Input:  " + Arrays.toString(marks2) + ", k = " + k2);
        System.out.println("Expected Output: 90");
        System.out.println("Actual Output:   " + kthHighest(marks2.clone(), k2));
    }
}

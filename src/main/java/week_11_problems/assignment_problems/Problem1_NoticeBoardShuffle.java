package main.java.week_11_problems.assignment_problems;

import java.util.Arrays;

public class Problem1_NoticeBoardShuffle {

    /**
     * Sorts the scores array using optimized Bubble Sort and returns statistics.
     *
     * @param scores The array of test scores to sort in-place.
     * @return int[] containing {passes, swaps}.
     */
    public static int[] bubbleStats(int[] scores) {
        int passes = 0;
        int swaps = 0;
        int n = scores.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            passes++; // Count the pass as soon as it begins

            for (int j = 0; j < n - 1 - i; j++) {
                if (scores[j] > scores[j + 1]) {
                    // Swap adjacent elements
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            // If no elements were swapped during this sweep, the array is sorted
            if (!swapped) {
                break;
            }
        }

        // Handle edge case for an empty or single-element array where loop doesn't run
        if (n <= 1 && passes == 0) {
            passes = (n == 1) ? 1 : 0;
        }

        return new int[]{passes, swaps};
    }

    public static void main(String[] args) {
        // Sample 1
        int[] scores1 = {5, 1, 4, 2, 8};
        System.out.println("Original 1: " + Arrays.toString(scores1));
        int[] stats1 = bubbleStats(scores1);
        System.out.println("Sorted 1:   " + Arrays.toString(scores1));
        System.out.println("Passes: " + stats1[0] + ", Swaps: " + stats1[1]);
        System.out.println();

        // Sample 2
        int[] scores2 = {1, 2, 3, 4};
        System.out.println("Original 2: " + Arrays.toString(scores2));
        int[] stats2 = bubbleStats(scores2);
        System.out.println("Sorted 2:   " + Arrays.toString(scores2));
        System.out.println("Passes: " + stats2[0] + ", Swaps: " + stats2[1]);
    }
}

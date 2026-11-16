package main.java.week_11_problems.assignment_problems;

import java.util.Arrays;

public class Problem5_ContestLeaderboard {

    // Entry class definition
    static class Entry {
        String name;
        int marks;

        Entry(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return name + " " + marks;
        }
    }

    /**
     * Sorts contest entries from highest marks to lowest using Counting Sort.
     * Preserves submission order for students with equal marks (stable sort).
     *
     * @param entries Array of Entry objects.
     * @return A new Entry[] array containing the sorted leaderboard.
     */
    public static Entry[] leaderboard(Entry[] entries) {
        if (entries == null || entries.length == 0) {
            return new Entry[0];
        }

        int n = entries.length;
        int K = 101; // Marks range from 0 to 100 (total 101 possible values)
        int[] count = new int[K];
        Entry[] output = new Entry[n];

        // Step 1: Count frequencies using key = 100 - marks
        // Higher marks get smaller keys (100 -> 0, 90 -> 10, etc.)
        for (int i = 0; i < n; i++) {
            int key = 100 - entries[i].marks;
            count[key]++;
        }

        // Step 2: Compute cumulative (prefix) counts
        for (int i = 1; i < K; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build output array by traversing input from RIGHT to LEFT to maintain stability
        for (int i = n - 1; i >= 0; i--) {
            int key = 100 - entries[i].marks;
            output[count[key] - 1] = entries[i];
            count[key]--;
        }

        return output;
    }

    public static void main(String[] args) {
        // Sample Input: Asha 90, Ravi 75, Neha 90, Kiran 100, Meera 75[cite: 25]
        Entry[] entries = {
                new Entry("Asha", 90),
                new Entry("Ravi", 75),
                new Entry("Neha", 90),
                new Entry("Kiran", 100),
                new Entry("Meera", 75)
        };

        System.out.println("Input:    " + Arrays.toString(entries));

        Entry[] result = leaderboard(entries);

        System.out.println("Output:   " + Arrays.toString(result));
        // Expected Output: Kiran 100, Asha 90, Neha 90, Ravi 75, Meera 75[cite: 25]
    }
}

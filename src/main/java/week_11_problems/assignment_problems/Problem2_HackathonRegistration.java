package main.java.week_11_problems.assignment_problems;

import java.util.Arrays;

public class Problem2_HackathonRegistration {

    // Team class definition
    static class Team {
        String name;
        int size;

        Team(String name, int size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public String toString() {
            return name + "(" + size + ")";
        }
    }

    /**
     * Sorts teams in-place by size in ascending order using Insertion Sort logic.
     * Preserves original registration order for teams of equal size (stable sort).
     *
     * @param teams Array of Team objects to sort in-place.
     */
    public static void sortTeams(Team[] teams) {
        if (teams == null || teams.length <= 1) {
            return;
        }

        int n = teams.length;

        // Insertion Sort
        for (int i = 1; i < n; i++) {
            Team key = teams[i];
            int j = i - 1;

            // Shift elements of teams[0..i-1] right if their size is STRICTLY GREATER than key's size.
            // Using > ensures stability (equal elements maintain original relative order).
            while (j >= 0 && teams[j].size > key.size) {
                teams[j + 1] = teams[j];
                j--;
            }

            // Drop key into the open slot
            teams[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        // Sample Input: Pixel(4), Byte(2), Nova(4), Echo(3), Atom(2)
        Team[] teams = {
                new Team("Pixel", 4),
                new Team("Byte", 2),
                new Team("Nova", 4),
                new Team("Echo", 3),
                new Team("Atom", 2)
        };

        System.out.println("Before Sorting: " + Arrays.toString(teams));

        sortTeams(teams);

        System.out.println("After Sorting:  " + Arrays.toString(teams));
        // Expected Output: Byte(2), Atom(2), Echo(3), Pixel(4), Nova(4)
    }
}

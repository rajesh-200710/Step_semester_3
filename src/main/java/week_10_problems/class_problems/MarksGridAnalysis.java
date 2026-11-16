package week_10_problems.class_problems;

import java.util.*;

public class MarksGridAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        List<int[]> marksList = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            int bracketStart = line.indexOf('[');
            int bracketEnd = line.indexOf(']');
            if (bracketStart == -1 || bracketEnd == -1) continue;

            String name = line.substring(0, bracketStart).trim();
            String marksPart = line.substring(bracketStart + 1, bracketEnd);
            String[] parts = marksPart.split(",");

            int[] marks = new int[3];
            for (int i = 0; i < 3; i++) {
                marks[i] = Integer.parseInt(parts[i].trim());
            }

            names.add(name);
            marksList.add(marks);
        }
        sc.close();

        int n = names.size();
        if (n == 0) return;

        int[][] grid = new int[n][3];
        for (int i = 0; i < n; i++) {
            grid[i] = marksList.get(i);
        }

        int[] totals = new int[n];
        double[] subjectSums = new double[3];
        int maxTotal = -1;
        String topper = "";

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += grid[i][j];
                subjectSums[j] += grid[i][j];
            }
            totals[i] = sum;
            if (sum > maxTotal) {
                maxTotal = sum;
                topper = names.get(i);
            }
        }

        StringBuilder totalsOut = new StringBuilder("Totals ");
        for (int i = 0; i < n; i++) {
            totalsOut.append(names.get(i)).append(" ").append(totals[i]);
            if (i < n - 1) totalsOut.append(", ");
        }
        System.out.println(totalsOut.toString());

        System.out.printf("averages %.2f, %.2f, %.2f%n",
                subjectSums[0] / n, subjectSums[1] / n, subjectSums[2] / n);
        System.out.println("topper " + topper + " (" + maxTotal + ")");
    }
}

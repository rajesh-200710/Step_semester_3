package week_12_problems.class_problems;

import java.util.*;

public class ScoreBandCounter {
    public static int lowerBound(int[] scores, int x) {
        int low = 0;
        int high = scores.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;

        String line = sc.nextLine();
        int start = line.indexOf('[');
        int end = line.indexOf(']');
        String[] parts = line.substring(start + 1, end).split(",");

        int[] scores = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            scores[i] = Integer.parseInt(parts[i].trim());
        }

        while (sc.hasNext()) {
            String token = sc.next();
            if (token.equalsIgnoreCase("QUERY")) {
                int x = sc.nextInt();
                int below = lowerBound(scores, x);
                int exactly = lowerBound(scores, x + 1) - below;
                System.out.println(x + ": exactly " + exactly + ", below " + below);
            }
        }
        sc.close();
    }
}
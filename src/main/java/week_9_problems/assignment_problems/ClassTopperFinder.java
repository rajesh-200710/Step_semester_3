package main.java.week_9_problems.assignment_problems;

public class ClassTopperFinder {

    // Helper class to hold the tuple (rowIndex, total)
    public static class Result {
        public int rowIndex;
        public int total;

        public Result(int rowIndex, int total) {
            this.rowIndex = rowIndex;
            this.total = total;
        }

        @Override
        public String toString() {
            return "(" + rowIndex + ", " + total + ")";
        }
    }

    /**
     * Finds the student with the highest total marks.
     * Breaks ties by selecting the smaller row index.
     */
    public static Result findTopper(int[][] marks) {
        if (marks == null || marks.length == 0) {
            return new Result(-1, 0);
        }

        int maxTotal = -1;
        int topperRowIndex = -1;

        for (int i = 0; i < marks.length; i++) {
            int currentTotal = 0;
            for (int j = 0; j < marks[i].length; j++) {
                currentTotal += marks[i][j];
            }
            // Update only if strictly greater to preserve smaller row index on ties
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                topperRowIndex = i;
            }
        }

        return new Result(topperRowIndex, maxTotal);
    }

    public static void main(String[] args) {
        int[][] marks = {
                {78, 85, 90}, // Sum: 253
                {88, 92, 79}, // Sum: 259
                {65, 70, 95}  // Sum: 230
        };

        Result topper = findTopper(marks);
        System.out.println("Topper: " + topper); // Expected: (1, 259)
    }
}

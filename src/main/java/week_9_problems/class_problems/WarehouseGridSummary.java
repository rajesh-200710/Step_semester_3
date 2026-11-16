package main.java.week_9_problems.class_problems;

public class WarehouseGridSummary {

    public static class Coordinate {
        public int row;
        public int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }

    public static class SummaryResult {
        public long totalItems;
        public Coordinate maxCoordinate;

        public SummaryResult(long totalItems, Coordinate maxCoordinate) {
            this.totalItems = totalItems;
            this.maxCoordinate = maxCoordinate;
        }

        @Override
        public String toString() {
            return "(" + totalItems + ", " + maxCoordinate + ")";
        }
    }

    public static SummaryResult warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new SummaryResult(0, new Coordinate(0, 0));
        }

        long totalItems = 0;
        int maxVal = -1;
        Coordinate maxCoord = new Coordinate(0, 0);

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int val = grid[r][c];
                totalItems += val;

                // Strict inequality preserves first encountered bin in row-major order
                if (val > maxVal) {
                    maxVal = val;
                    maxCoord = new Coordinate(r, c);
                }
            }
        }

        return new SummaryResult(totalItems, maxCoord);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {4, 9, 2},
                {7, 1, 6},
                {3, 12, 5}
        };

        System.out.println(warehouseSummary(grid)); // Expected: (49, (2, 1))
    }
}

package main.java.week_9_problems.class_problems;

public class MaximizeAreaBetweenBoundaries {

    /**
     * Optimal Approach: Two-Pointer Method
     */
    public static int maxContainerArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentWidth = right - left;
            int currentHeight = Math.min(heights[left], heights[right]);
            int currentArea = currentWidth * currentHeight;

            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer corresponding to the shorter wall
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Area: " + maxContainerArea(heights)); // Expected: 49
    }
}

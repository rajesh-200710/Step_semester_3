package main.java.week_9_problems.assignment_problems;

public class HotWeatherAlertWindows {

    /**
     * Counts consecutive k-hour blocks with average temperature >= threshold.
     * Uses sliding window technique to avoid re-summing.
     */
    public static int countAlerts(int[] readings, int k, int threshold) {
        if (readings == null || readings.length < k) {
            return 0;
        }

        // Avoid floating point division by comparing sum >= k * threshold
        long targetSum = (long) k * threshold;
        long currentSum = 0;

        // Compute sum for the first window
        for (int i = 0; i < k; i++) {
            currentSum += readings[i];
        }

        int alertCount = 0;
        if (currentSum >= targetSum) {
            alertCount++;
        }

        // Slide the window across the remaining readings
        for (int i = k; i < readings.length; i++) {
            currentSum += readings[i] - readings[i - k];
            if (currentSum >= targetSum) {
                alertCount++;
            }
        }

        return alertCount;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;

        System.out.println("Alert Count: " + countAlerts(readings, k, threshold)); // Expected: 3
    }
}

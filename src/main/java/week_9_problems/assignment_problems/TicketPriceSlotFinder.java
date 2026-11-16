package main.java.week_9_problems.assignment_problems;

public class TicketPriceSlotFinder {

    /**
     * Performs Binary Search to find price index or insertion slot.
     */
    public static int findSlot(int[] prices, int newPrice) {
        int low = 0;
        int high = prices.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (prices[mid] == newPrice) {
                return mid;
            } else if (prices[mid] < newPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // If not found, low points to the exact insertion index
        return low;
    }

    public static void main(String[] args) {
        int[] prices = {120, 150, 200, 260};

        System.out.println(findSlot(prices, 150)); // Expected: 1
        System.out.println(findSlot(prices, 210)); // Expected: 3
        System.out.println(findSlot(prices, 300)); // Expected: 4
    }
}

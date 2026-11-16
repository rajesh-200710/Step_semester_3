package main.java.week_9_problems.assignment_problems;

import java.util.HashMap;
import java.util.Map;

public class MostPopularCanteenOrder {

    public static class Result {
        public String item;
        public int count;

        public Result(String item, int count) {
            this.item = item;
            this.count = count;
        }

        @Override
        public String toString() {
            return "(\"" + item + "\", " + count + ")";
        }
    }

    /**
     * Finds the most frequently ordered item.
     * Ties are broken by picking the item that appears first in the original list.
     */
    public static Result mostPopular(String[] orders) {
        if (orders == null || orders.length == 0) {
            return new Result("", 0);
        }

        // Pass 1: Build frequency map
        Map<String, Integer> counts = new HashMap<>();
        for (String order : orders) {
            counts.put(order, counts.getOrDefault(order, 0) + 1);
        }

        // Pass 2: Iterate original list to break ties using first appearance
        int maxCount = 0;
        String popularItem = "";

        for (String order : orders) {
            int currentCount = counts.get(order);
            if (currentCount > maxCount) {
                maxCount = currentCount;
                popularItem = order;
            }
        }

        return new Result(popularItem, maxCount);
    }

    public static void main(String[] args) {
        String[] orders1 = {"dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"};
        System.out.println(mostPopular(orders1)); // ("dosa", 3)

        String[] orders2 = {"tea", "coffee", "coffee", "tea"};
        System.out.println(mostPopular(orders2)); // ("tea", 2)
    }
}

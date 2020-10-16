package com.jake.solution;

public class N0122_BestTimeToBuyAndSellStockII {

    // nested loop
    public int maxProfit(int[] prices) {
        int r = 0;

        int profit = 0;
        int right = 0;
        for (int left = 0; left < prices.length; left++) {
            left = right;
            for (right = left + 1; right < prices.length; right++) {
                if (prices[right] - prices[right - 1] < 0) {
                    break;
                } else {
                    profit = prices[right] - prices[left];
                }
            }
            r += profit;
            profit = 0;
        }
        return r;
    }

    // one pass
    public int maxProfit2(int[] prices) {
        int r = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                r += prices[i + 1] - prices[i];
            }
        }
        return r;
    }
}

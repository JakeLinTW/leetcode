package com.jake.solution;

public class N0122_BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int r = N0122_BestTimeToBuyAndSellStockII.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
        System.out.println(r); // 7

        r = N0122_BestTimeToBuyAndSellStockII.maxProfit(new int[] { 1, 2, 3, 4, 5 });
        System.out.println(r); // 4

        r = N0122_BestTimeToBuyAndSellStockII.maxProfit2(new int[] { 7, 6, 4, 3, 1 });
        System.out.println(r); // 0

        r = N0122_BestTimeToBuyAndSellStockII.maxProfit2(new int[] { 2, 1, 2, 0, 1 });
        System.out.println(r); // 2
    }

    // nested loop
    public static int maxProfit(int[] prices) {
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
    public static int maxProfit2(int[] prices) {
        int r = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                r += prices[i + 1] - prices[i];
            }
        }
        return r;
    }
}

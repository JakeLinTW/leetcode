package com.jake.solution;

public class N0121_BestTimeToBuyAndSellStock {

    // nested loop
    public int maxProfit(int[] prices) {
        int max = 0;

        int size = prices.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int temp = prices[j] - prices[i];
                if (temp > max) {
                    max = temp;
                }
            }
        }

        return max;
    }

    // two pointer
    public int maxProfit2(int[] prices) {
        int max = 0;

        int i = 0;
        int j = 1;
        while (j < prices.length) {
            int temp = prices[j] - prices[i];
            if (temp < 0) {
                i = j;
            } else if (temp > max) {
                max = temp;
            }
            j++;
        }

        return max;
    }

    // keep lowest price
    public int maxProfit3(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else if (prices[i] - minValue > max) {
                max = prices[i] - minValue;
            }
        }
        return max;
    }
}

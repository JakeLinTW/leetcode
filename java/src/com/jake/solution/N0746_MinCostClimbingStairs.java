package com.jake.solution;

public class N0746_MinCostClimbingStairs {

    // dynamic Programming
    public int minCostClimbingStairs(int[] cost) {
        int next1 = 0;
        int next2 = 0;

        int i = cost.length;
        while (i-- > 0) {
            int curr = cost[i] + Math.min(next1, next2);
            next2 = next1;
            next1 = curr;
        }
        return Math.min(next1, next2);
    }

    // dynamic Programming, forward traverse
    public int minCostClimbingStairs2(int[] cost) {
        int pre1 = 0;
        int pre2 = 0;

        for (int i = 0; i < cost.length; i++) {
            int curr = cost[i] + Math.min(pre1, pre2);
            pre2 = pre1;
            pre1 = curr;
        }
        return Math.min(pre1, pre2);
    }

    // dynamic Programming, change cost array to total cost array
    public int minCostClimbingStairs3(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}

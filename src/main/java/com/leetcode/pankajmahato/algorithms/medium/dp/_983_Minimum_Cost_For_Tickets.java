/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 *
 * You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in three different ways:
 *
 * a 1-day pass is sold for costs[0] dollars,
 * a 7-day pass is sold for costs[1] dollars, and
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.
 *
 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 *
 *
 *
 * Example 1:
 *
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total, you spent $11 and covered all the days of your travel.
 * Example 2:
 *
 * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * Output: 17
 * Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
 * On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
 * In total, you spent $17 and covered all the days of your travel.
 *
 *
 * Constraints:
 *
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days is in strictly increasing order.
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _983_Minimum_Cost_For_Tickets {

//    public int mincostTickets(int[] days, int[] costs) {
//
//        // DP with top down
//        int n = days.length;
//
//        // dp[i] = Minimum till i-th index day
//        Integer[] dp = new Integer[n];
//
//        return solve(days, n, costs, 0, 0, dp);
//    }
//
//    private int solve(int[] days, int n, int[] costs, int idx, int validity, Integer[] dp) {
//
//        if (idx >= n) {
//            return 0;
//        }
//
//        if (days[idx] < validity) {
//            return solve(days, n, costs, idx + 1, validity, dp);
//        }
//
//        if (dp[idx] != null) {
//            return dp[idx];
//        }
//
//        int cost1Day = costs[0] + solve(days, n, costs, idx + 1, 1 + days[idx], dp);
//        int cost7Day = costs[1] + solve(days, n, costs, idx + 1, 7 + days[idx], dp);
//        int cost30Day = costs[2] + solve(days, n, costs, idx + 1, 30 + days[idx],
//                dp);
//
//        return dp[idx] = Math.min(cost1Day, Math.min(cost7Day, cost30Day));
//    }

    public int mincostTickets(int[] days, int[] costs) {

        // DP with bottom up
        int n = days.length;

        // dp[i] = Minimum till i-th index day
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            // 1 day pass
            dp[i] = dp[i - 1] + costs[0];

            // 7 day pass
            int j = i - 1;
            while (j >= 0 && days[i - 1] - days[j] < 7) {
                j--;
            }
            dp[i] = Math.min(dp[i], costs[1] + dp[j + 1]);

            // 30 day pass
            j = i - 1;
            while (j >= 0 && days[i - 1] - days[j] < 30) {
                j--;
            }
            dp[i] = Math.min(dp[i], costs[2] + dp[j + 1]);
        }

        return dp[n];
    }
}

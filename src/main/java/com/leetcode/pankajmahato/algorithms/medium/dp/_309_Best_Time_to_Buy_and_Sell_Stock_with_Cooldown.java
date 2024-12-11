/**********************************************************************************
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * Example 2:
 *
 * Input: prices = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

//    public int maxProfit(int[] prices) {
//
//        // DP with top down
//        int n = prices.length;
//
//        // dp[i][j] = Maximum profit till i-th day if we buy/sell (j -> 1(buy) ;
//        // 0(sell))
//        Integer[][] dp = new Integer[n][2];
//
//        return solve(prices, n, 0, true, dp);
//    }
//
//    private int solve(int[] prices, int n, int day, boolean isBuy, Integer[][]
//            dp) {
//
//        if (day >= n) {
//            return 0;
//        }
//
//        int buyInt = isBuy ? 1 : 0;
//        if (dp[day][buyInt] != null) {
//            return dp[day][buyInt];
//        }
//
//        int profit = 0;
//        // Buying case
//        if (isBuy == true) {
//            // After buy it has to sold
//            int buy = solve(prices, n, day + 1, false, dp) - prices[day];
//            // If not buying then buy on next day
//            int notBuy = solve(prices, n, day + 1, true, dp);
//            profit = Math.max(profit, Math.max(buy, notBuy));
//        } else {
//            // Selling case
//            // After selling buy with cooldown (day+2)
//            int sell = prices[day] + solve(prices, n, day + 2, true, dp);
//            // It not selling then sell on next day
//            int notSell = solve(prices, n, day + 1, false, dp);
//            profit = Math.max(profit, Math.max(sell, notSell));
//        }
//
//        return dp[day][buyInt] = profit;
//    }

    public int maxProfit(int[] prices) {

        // DP with bottom up
        int n = prices.length;

        if (n <= 1) {
            return 0;
        }

        // dp[i] = Maximum profit till i-th
        int[] dp = new int[n];

        dp[0] = 0;
        dp[1] = Math.max(prices[1] - prices[0], 0);

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1];
            for (int j = 0; j <= i - 1; j++) {
                int prevProfit = j >= 2 ? dp[j - 2] : 0;
                dp[i] = Math.max(dp[i], prices[i] - prices[j] + prevProfit);
            }
        }

        return dp[n - 1];
    }
}

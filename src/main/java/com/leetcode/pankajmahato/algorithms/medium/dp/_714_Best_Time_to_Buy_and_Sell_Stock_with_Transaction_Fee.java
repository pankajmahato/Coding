/**********************************************************************************
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 *
 * Note:
 *
 * You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * The transaction fee is only charged once for each stock purchase and sale.
 *
 *
 * Example 1:
 *
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Example 2:
 *
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 5 * 104
 * 1 <= prices[i] < 5 * 104
 * 0 <= fee < 5 * 104
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

    public int maxProfit(int[] prices, int fee) {

        // DP Top Down

        int n = prices.length;

        // dp[i][j] = Profit for buy/sell at day i
        int[][] dp = new int[n][2];

        for (int[] arr : dp) {
            arr[0] = -1;
            arr[1] = -1;
        }

        return solve(0, 1, n, prices, fee, dp);
    }

    private int solve(int day, int buy, int n, int[] prices, int fee, int[][] dp) {

        if (day >= n) {
            return 0;
        }

        if (dp[day][buy] != -1) {
            return dp[day][buy];
        }

        int profit = 0;
        if (buy == 1) {

            int take = solve(day + 1, 0, n, prices, fee, dp) - prices[day];
            int skip = solve(day + 1, 1, n, prices, fee, dp);
            profit = Math.max(take, skip);
        } else {

            int take = solve(day + 1, 1, n, prices, fee, dp) + prices[day] - fee;
            int skip = solve(day + 1, 0, n, prices, fee, dp);
            profit = Math.max(take, skip);
        }

        return dp[day][buy] = profit;
    }
}

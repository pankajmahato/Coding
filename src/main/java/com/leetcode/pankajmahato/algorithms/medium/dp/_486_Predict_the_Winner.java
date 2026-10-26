/**********************************************************************************
 *
 * https://leetcode.com/problems/predict-the-winner/
 *
 * You are given an integer array nums.
 *
 * Two players are playing a game with this array: Player 1 and Player 2.
 *
 * Player 1 and Player 2 take turns, with Player 1 starting first. Both players start the game with a score of 0.
 *
 * At each turn, the current player takes the number at either end of the array (i.e., nums[0] or nums[nums.length - 1]), removing it from the array and adding it to their own score. The game ends when there are no more elements in the array.
 *
 * Return true if Player 1's final score is greater than or equal to Player 2's final score, and false otherwise.
 *
 * Note that a tie counts as a win for Player 1. You may assume that both players play optimally.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,2]
 *
 * Output: false
 *
 * Explanation:
 *
 * Player 1 must open by taking either 1 or 2, and both choices lead to the same result.
 * If Player 1 takes 1, the array becomes [5,2]. Player 2 takes 5, leaving 2 for Player 1.
 * If Player 1 takes 2, the array becomes [1,5]. Player 2 takes 5, leaving 1 for Player 1.
 * Either way, Player 1 finishes with 1 + 2 = 3 and Player 2 finishes with 5. Player 1 can never win, so return false.
 * Example 2:
 *
 * Input: nums = [1,5,233,7]
 *
 * Output: true
 *
 * Explanation:
 *
 * Player 1 first takes 1, leaving [5,233,7]. Player 2 must then choose between 5 and 7, and no matter which number Player 2 chooses, Player 1 can take 233 on the next turn.
 * Player 1 finishes with a higher score (234) than Player 2 (12), so return true.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 107
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

import java.util.Arrays;

public class _486_Predict_the_Winner {

//    public boolean predictTheWinner(int[] nums) {
//
//        // DP Top Down option 1
//
//        int n = nums.length;
//
//        // dp[i][j] = player1 score for index i & j
//        int[][] dp = new int[n][n];
//        for (int[] arr : dp) {
//            Arrays.fill(arr, -1);
//        }
//
//        int total = 0;
//        for (int num : nums) {
//            total += num;
//        }
//
//        int player1 = solveForPlayer1(0, n - 1, nums, dp);
//        int player2 = total - player1;
//
//        return player1 >= player2;
//    }
//
//    private int solveForPlayer1(int i, int j, int[] nums, int[][] dp) {
//
//        if (i > j) {
//            return 0;
//        }
//
//        if (i == j) {
//            return nums[i];
//        }
//
//        if (dp[i][j] != -1) {
//            return dp[i][j];
//        }
//
//        // Player1 picks left
//        int takeLeft = nums[i];
//
//        // Player2 plays optimally, then Player1 plays so Player1 score will be minimum
//        int leftPlayer1 = Math.min(solveForPlayer1(i + 2, j, nums, dp), solveForPlayer1(i + 1, j - 1, nums, dp));
//
//        int leftScore = takeLeft + leftPlayer1;
//
//        // Player1 picks right
//        int takeRight = nums[j];
//
//        // Player2 plays optimally, then Player1 plays so Player1 score will be minimum
//        int rightPlayer1 = Math.min(solveForPlayer1(i, j - 2, nums, dp), solveForPlayer1(i + 1, j - 1, nums, dp));
//
//        int rightScore = takeRight + rightPlayer1;
//
//        return dp[i][j] = Math.max(leftScore, rightScore);
//    }

    public boolean predictTheWinner(int[] nums) {

        // DP Top Down option 2

        int n = nums.length;

        // dp[i][j] = difference of score for index i & j
        int[][] dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int diff = solve(0, n - 1, nums, dp);

        return diff >= 0;
    }

    private int solve(int i, int j, int[] nums, int[][] dp) {

        if (i > j) {
            return 0;
        }

        if (i == j) {
            return nums[i];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Player picks left
        int takeLeft = nums[i] - solve(i + 1, j, nums, dp);

        // Player picks right
        int takeRight = nums[j] - solve(i, j - 1, nums, dp);

        return dp[i][j] = Math.max(takeLeft, takeRight);
    }
}

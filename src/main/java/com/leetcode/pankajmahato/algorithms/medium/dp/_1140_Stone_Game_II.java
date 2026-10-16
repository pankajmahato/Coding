/**********************************************************************************
 *
 * https://leetcode.com/problems/stone-game-ii/
 *
 * Alice and Bob continue their games with piles of stones. There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i]. The objective of the game is to end with the most stones.
 *
 * Alice and Bob take turns, with Alice starting first.
 *
 * On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M. Then, we set M = max(M, X). Initially, M = 1.
 *
 * The game continues until all the stones have been taken.
 *
 * Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.
 *
 *
 *
 * Example 1:
 *
 * Input: piles = [2,7,9,4,4]
 *
 * Output: 10
 *
 * Explanation:
 *
 * If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 stones in total.
 * If Alice takes two piles at the beginning, then Bob can take all three piles left. In this case, Alice get 2 + 7 = 9 stones in total.
 * So we return 10 since it's larger.
 *
 * Example 2:
 *
 * Input: piles = [1,2,3,4,5,100]
 *
 * Output: 104
 *
 *
 *
 * Constraints:
 *
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 104
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

import java.util.Arrays;

public class _1140_Stone_Game_II {

    public int stoneGameII(int[] piles) {

        // DP Top Down

        int n = piles.length;

        // dp[i][j][k] = Maximum score of person i from index j with max M as k
        int[][][] dp = new int[2][n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[0][i], -1);
            Arrays.fill(dp[1][i], -1);
        }

        return solve(1, 0, 1, n, piles, dp);
    }

    private int solve(int person, int i, int M, int n, int[] piles, int[][][] dp) {

        if (i >= n) {
            return 0;
        }

        if (dp[person][i][M] != -1) {
            return dp[person][i][M];
        }
        int score = 0;
        int result = person == 1 ? -1 : Integer.MAX_VALUE;
        for (int x = 1; x <= Math.min(2 * M, n - i); x++) {

            score += piles[i + x - 1];

            if (person == 1) {
                // Alice
                int bob = solve(0, i + x, Math.max(M, x), n, piles, dp);
                result = Math.max(result, score + bob);
            } else {
                // Bob

                int alice = solve(1, i + x, Math.max(M, x), n, piles, dp);
                result = Math.min(result, alice);
            }
        }

        return dp[person][i][M] = result;
    }
}

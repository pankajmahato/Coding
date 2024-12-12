/**********************************************************************************
 *
 * https://leetcode.com/problems/reducing-dishes/
 *
 * A chef has collected data on the satisfaction level of his n dishes. Chef can cook any dish in 1 unit of time.
 *
 * Like-time coefficient of a dish is defined as the time taken to cook that dish including previous dishes multiplied by its satisfaction level i.e. time[i] * satisfaction[i].
 *
 * Return the maximum sum of like-time coefficient that the chef can obtain after preparing some amount of dishes.
 *
 * Dishes can be prepared in any order and the chef can discard some dishes to get this maximum value.
 *
 *
 *
 * Example 1:
 *
 * Input: satisfaction = [-1,-8,0,5,-9]
 * Output: 14
 * Explanation: After Removing the second and last dish, the maximum total like-time coefficient will be equal to (-1*1 + 0*2 + 5*3 = 14).
 * Each dish is prepared in one unit of time.
 * Example 2:
 *
 * Input: satisfaction = [4,3,2]
 * Output: 20
 * Explanation: Dishes can be prepared in any order, (2*1 + 3*2 + 4*3 = 20)
 * Example 3:
 *
 * Input: satisfaction = [-1,-4,-5]
 * Output: 0
 * Explanation: People do not like the dishes. No dish is prepared.
 *
 *
 * Constraints:
 *
 * n == satisfaction.length
 * 1 <= n <= 500
 * -1000 <= satisfaction[i] <= 1000
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.dp;

import java.util.Arrays;

public class _1402_Reducing_Dishes {

//    public int maxSatisfaction(int[] satisfaction) {
//
//        // DP with top down
//        int[] s = satisfaction;
//        int n = s.length;
//
//        // Sort so that the highest satisfaction is cooked at last
//        Arrays.sort(s);
//
//        // dp[i][j] = Maximum till i-th dish with time j;
//        Integer[][] dp = new Integer[n][n + 1];
//
//        return solve(s, n, 0, 1, dp);
//    }
//
//    private int solve(int[] s, int n, int idx, int time, Integer[][] dp) {
//
//        if (idx == n) {
//            return 0;
//        }
//
//        if (dp[idx][time] != null) {
//            return dp[idx][time];
//        }
//
//        int include = s[idx] * time + solve(s, n, idx + 1, time + 1, dp);
//        int exclude = solve(s, n, idx + 1, time, dp);
//
//        return dp[idx][time] = Math.max(include, exclude);
//    }

    public int maxSatisfaction(int[] satisfaction) {

        // DP with bottom up
        int[] s = satisfaction;
        int n = s.length;

        // Sort so that the highest satisfaction is cooked at last
        Arrays.sort(s);

        // dp[i][j] = Maximum till i-th dish with time j;
        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1_000_000_000;
            }
        }

        dp[0][1] = s[0];

        for (int i = 1; i < n; i++) {
            for (int time = 1; time <= n; time++) {

                int include = s[i] * time + dp[i - 1][time - 1];
                int exclude = dp[i - 1][time];

                dp[i][time] = Math.max(include, exclude);
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            result = Math.max(result, dp[n - 1][i]);
        }

        return result;
    }
}

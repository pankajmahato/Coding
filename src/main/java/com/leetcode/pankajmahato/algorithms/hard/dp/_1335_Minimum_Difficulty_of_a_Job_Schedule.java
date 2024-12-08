/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 *
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).
 *
 * You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.
 *
 * You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].
 *
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: jobDifficulty = [6,5,4,3,2,1], d = 2
 * Output: 7
 * Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
 * Second day you can finish the last job, total difficulty = 1.
 * The difficulty of the schedule = 6 + 1 = 7 
 * Example 2:
 *
 * Input: jobDifficulty = [9,9,9], d = 4
 * Output: -1
 * Explanation: If you finish a job per day you will still have a free day. you cannot find a schedule for the given jobs.
 * Example 3:
 *
 * Input: jobDifficulty = [1,1,1], d = 3
 * Output: 3
 * Explanation: The schedule is one job per day. total difficulty will be 3.
 *
 *
 * Constraints:
 *
 * 1 <= jobDifficulty.length <= 300
 * 0 <= jobDifficulty[i] <= 1000
 * 1 <= d <= 10
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.dp;

public class _1335_Minimum_Difficulty_of_a_Job_Schedule {

//    public int minDifficulty(int[] jobDifficulty, int d) {
//
//        // DP with top down
//        int[] jd = jobDifficulty;
//        int n = jd.length;
//
//        if (n < d) {
//            return -1;
//        }
//
//        // dp[i][j] = minimum difficulty for day i till i-th index job
//        int[][] dp = new int[d + 1][n + 1];
//
//        for (int i = 0; i <= d; i++) {
//            for (int j = 0; j <= n; j++) {
//                dp[i][j] = -1;
//            }
//        }
//
//        return solve(jd, n, 0, d, dp);
//    }
//
//    private int solve(int[] jd, int n, int idx, int d, int[][] dp) {
//
//        if (dp[d][idx] != -1) {
//            return dp[d][idx];
//        }
//
//        if (d == 1) {
//            int maxInDay = jd[idx];
//            for (int i = idx; i < n; i++) {
//                maxInDay = Math.max(maxInDay, jd[i]);
//            }
//            return maxInDay;
//        }
//
//        int maxInDay = Integer.MIN_VALUE;
//        int finalResult = Integer.MAX_VALUE;
//        for (int i = idx; i <= n - d; i++) {
//            maxInDay = Math.max(maxInDay, jd[i]);
//            int result = maxInDay + solve(jd, n, i + 1, d - 1, dp);
//            finalResult = Math.min(finalResult, result);
//        }
//
//        return dp[d][idx] = finalResult;
//    }

    public int minDifficulty(int[] jobDifficulty, int d) {

        // DP with bottom up
        int[] jd = jobDifficulty;
        int n = jd.length;

        if (n < d) {
            return -1;
        }

        // dp[i][j] = minimum difficulty for jobs i-th to (n-1)th index till day j
        int[][] dp = new int[n][d + 1];

        int maxInDay1 = jd[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= d; j++) {
                // For day == 1, the minimum difficulty is the maximum of all the jobs from i-th
                // to (n-1)th index
                if (j == 1) {
                    maxInDay1 = Math.max(maxInDay1, jd[i]);
                    dp[i][j] = maxInDay1;
                } else {
                    dp[i][j] = -1;
                }
            }
        }

        for (int day = 2; day <= d; day++) {
            for (int i = 0; i <= n - day; i++) {
                int maxInDay = Integer.MIN_VALUE;
                int finalResult = Integer.MAX_VALUE;
                for (int j = i; j <= n - day; j++) {
                    maxInDay = Math.max(maxInDay, jd[j]);
                    int result = maxInDay + dp[j + 1][day - 1];
                    finalResult = Math.min(finalResult, result);
                }

                dp[i][day] = finalResult;
            }
        }

        // The result for day d will the minimum from 0th to (n-1)th index
        return dp[0][d];
    }
}

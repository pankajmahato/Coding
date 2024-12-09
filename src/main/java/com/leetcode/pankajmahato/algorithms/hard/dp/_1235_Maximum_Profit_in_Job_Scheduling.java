/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 *
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 *
 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
 *
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120
 * Explanation: The subset chosen is the first and fourth job. 
 * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 * Example 2:
 *
 *
 *
 * Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * Output: 150
 * Explanation: The subset chosen is the first, fourth and fifth job. 
 * Profit obtained 150 = 20 + 70 + 60.
 * Example 3:
 *
 *
 *
 * Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 <= startTime.length == endTime.length == profit.length <= 5 * 104
 * 1 <= startTime[i] < endTime[i] <= 109
 * 1 <= profit[i] <= 104
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.dp;

import java.util.Arrays;

public class _1235_Maximum_Profit_in_Job_Scheduling {

//    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
//
//        // DP with bottom up
//        int n = startTime.length;
//        // dp[i] = Maximum profit till i-th job
//        Integer[] dp = new Integer[n + 1];
//
//        Integer[] idxArray = new Integer[n];
//        for (Integer i = 0; i < n; i++) {
//            idxArray[i] = i;
//        }
//
//        // Sort based on startTime
//        Arrays.sort(idxArray, (a, b) -> Integer.compare(startTime[a], startTime[b]));
//
//        return solve(idxArray, startTime, endTime, profit, n, 0, dp);
//    }
//
//    private int solve(Integer[] idxArray, int[] startTime, int[] endTime, int[] profit, int n, int idx, Integer[] dp) {
//        if (idx >= n) {
//            return 0;
//        }
//
//        if (dp[idx] != null) {
//            return dp[idx];
//        }
//
//        // Exclude the current job
//        int exclude = solve(idxArray, startTime, endTime, profit, n, idx + 1, dp);
//
//        // Include the current job and solve for next job having startTime >= current
//        // job endTime
//        int nextIdx = getNextIdx(idxArray, startTime, n, idx + 1, endTime[idxArray[idx]]);
//        int include = profit[idxArray[idx]] + solve(idxArray, startTime, endTime, profit, n, nextIdx, dp);
//
//        return dp[idx] = Math.max(exclude, include);
//    }
//
//    private int getNextIdx(Integer[] idxArray, int[] startTime, int n, int start, int endTime) {
//
//        int left = start;
//        int right = n - 1;
//
//        // Make out of bounds to exit
//        int result = n + 1;
//        while (left <= right) {
//
//            int mid = left + (right - left) / 2;
//            if (startTime[idxArray[mid]] >= endTime) {
//                result = mid;
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//
//        return result;
//    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        // DP with bottom up
        int n = startTime.length;
        // dp[i] = Maximum profit till i-th job
        Integer[] dp = new Integer[n];

        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        // Sort based on endTime
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {

            int exclude = dp[i - 1];
            // Include the current job and solve for previous job having endTime <= current
            // job startTime
            int prevIdx = getPrevIdx(jobs, 0, i - 1, jobs[i][0]);
            int prev = 0;
            // Exclude the current job
            if (prevIdx != -1) {
                prev = dp[prevIdx];
            }
            int include = prev + jobs[i][2];

            dp[i] = Math.max(exclude, include);
        }
        return dp[n - 1];
    }

    private int getPrevIdx(int[][] jobs, int left, int right, int startTime) {

        // Make out of bounds to exit
        int result = -1;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (jobs[mid][1] <= startTime) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}

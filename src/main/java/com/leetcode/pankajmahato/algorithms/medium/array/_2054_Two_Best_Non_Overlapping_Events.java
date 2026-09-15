/**********************************************************************************
 *
 * https://leetcode.com/problems/two-best-non-overlapping-events/
 *
 * You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei]. The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei. You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.
 *
 * Return this maximum sum.
 *
 * Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts and the other ends at the same time. More specifically, if you attend an event with end time t, the next event must start at or after t + 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: events = [[1,3,2],[4,5,2],[2,4,3]]
 * Output: 4
 * Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.
 * Example 2:
 *
 * Example 1 Diagram
 * Input: events = [[1,3,2],[4,5,2],[1,5,5]]
 * Output: 5
 * Explanation: Choose event 2 for a sum of 5.
 * Example 3:
 *
 *
 * Input: events = [[1,5,3],[1,5,1],[6,6,5]]
 * Output: 8
 * Explanation: Choose events 0 and 2 for a sum of 3 + 5 = 8.
 *
 *
 * Constraints:
 *
 * 2 <= events.length <= 105
 * events[i].length == 3
 * 1 <= startTimei <= endTimei <= 109
 * 1 <= valuei <= 106
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.Arrays;

public class _2054_Two_Best_Non_Overlapping_Events {

    public int maxTwoEvents(int[][] events) {

        // Sort by start time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int n = events.length;

        int[][] dp = new int[n + 1][3];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(events, n, 0, 0, dp);
    }

    private int solve(int[][] events, int n, int i, int count, int[][] dp) {

        if (count == 2 || i >= n) {
            return 0;
        }

        if (dp[i][count] != -1) {
            return dp[i][count];
        }

        int nextValidIndex = upperBound(events, n, events[i][1]);

        int take = events[i][2] + solve(events, n, nextValidIndex, count + 1, dp);

        int skip = solve(events, n, i + 1, count, dp);

        return dp[i][count] = Math.max(take, skip);
    }

    private int upperBound(int[][] events, int n, int endTime) {

        int l = 0;
        int r = n - 1;

        int result = n;
        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (events[mid][0] > endTime) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }
}

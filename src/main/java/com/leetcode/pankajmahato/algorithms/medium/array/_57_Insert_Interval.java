/**********************************************************************************
 *
 * https://leetcode.com/problems/insert-interval/
 *
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 *
 * Constraints:
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.ArrayList;
import java.util.List;

public class _57_Insert_Interval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        int start = 0;
        int end = 1;

        List<int[]> result = new ArrayList<>();

        int i = 0;
        for (; i < n; i++) {

            int[] curr = intervals[i];
            if (curr[end] < newInterval[start]) {
                result.add(curr);
            } else if (curr[start] > newInterval[end]) {
                break;
            } else {
                newInterval[start] = Math.min(newInterval[start], curr[start]);
                newInterval[end] = Math.max(newInterval[end], curr[end]);
            }
        }

        result.add(newInterval);
        for (; i < n; i++) {
            result.add(intervals[i]);
        }

        return result.toArray(new int[result.size()][]);
    }
}

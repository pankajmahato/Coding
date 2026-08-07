/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-time-difference/
 *
 * Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
 *
 *
 * Example 1:
 *
 * Input: timePoints = ["23:59","00:00"]
 * Output: 1
 * Example 2:
 *
 * Input: timePoints = ["00:00","23:59","00:00"]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 2 <= timePoints.length <= 2 * 104
 * timePoints[i] is in the format "HH:MM".
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.Arrays;
import java.util.List;

public class _539_Minimum_Time_Difference {

    public int findMinDifference(List<String> timePoints) {

        int n = timePoints.size();

        // Convert time to minutes with reference of 00:00 (12 AM)
        int[] minutes = new int[n];

        for (int i = 0; i < n; i++) {
            int hour = Integer.parseInt(timePoints.get(i).substring(0, 2)) * 60;
            int min = Integer.parseInt(timePoints.get(i).substring(3, 5));

            minutes[i] = hour + min;
        }

        Arrays.sort(minutes);

        int minTime = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minTime = Math.min(minTime, minutes[i] - minutes[i - 1]);
        }

        // Check for anti-clockwise diff
        minTime = Math.min(minTime, 24 * 60 - minutes[n - 1] + minutes[0]);

        return minTime;
    }
}

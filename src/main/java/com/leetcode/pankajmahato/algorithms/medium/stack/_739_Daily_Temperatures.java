/**********************************************************************************
 *
 * https://leetcode.com/problems/daily-temperatures/
 *
 * Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
 *
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 *
 * Constraints:
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _739_Daily_Temperatures {

    public int[] dailyTemperatures(int[] temperatures) {

        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return result;
    }
}

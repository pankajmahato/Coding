/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-swap/
 *
 * You are given an integer num. You can swap two digits at most once to get the maximum valued number.
 *
 * Return the maximum valued number you can get.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 *
 * Input: num = 9973
 * Output: 9973
 * Explanation: No swap.
 *
 *
 * Constraints:
 *
 * 0 <= num <= 108
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.string;

import java.util.Arrays;

public class _670_Maximum_Swap {

    public int maximumSwap(int num) {

        char[] nums = String.valueOf(num).toCharArray();
        int n = nums.length;

        // arr[i] = x; Index of maximum value towards right of number i is x
        int[] maxRightIndex = new int[10];
        Arrays.fill(maxRightIndex, -1);

        for (int i = 0; i < n; i++) {
            int idx = nums[i] - '0';
            maxRightIndex[idx] = i;
        }

        for (int i = 0; i < n; i++) {

            int curr = nums[i] - '0';

            for (int digit = 9; digit > curr; digit--) {
                if (maxRightIndex[digit] > i) {
                    char temp = nums[i];
                    nums[i] = nums[maxRightIndex[digit]];
                    nums[maxRightIndex[digit]] = temp;

                    return Integer.parseInt(String.valueOf(nums));
                }
            }
        }

        return num;
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/count-nice-pairs-in-an-array/
 *
 * You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:
 *
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [42,11,1,97]
 * Output: 2
 * Explanation: The two pairs are:
 *  - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
 *  - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
 * Example 2:
 *
 * Input: nums = [13,10,35,24,76]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.hashmap;

import java.util.HashMap;
import java.util.Map;

public class _1814_Count_Nice_Pairs_in_an_Array {

    public int countNicePairs(int[] nums) {

        int n = nums.length;

        // nums[i] + rev(nums[i] == nums[j] - rev(nums[j]))
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] - reverse(nums[i]);
        }

        long result = 0;
        int MOD = (int) 1e9 + 7;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            result = (result + map.getOrDefault(nums[i], 0)) % MOD;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return (int) result;
    }

    private int reverse(int n) {

        int rev = 0;
        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n = n / 10;
        }

        return rev;
    }
}

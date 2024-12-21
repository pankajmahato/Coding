/**********************************************************************************
 *
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 *
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
 *
 * A subarray is a contiguous part of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,1,0,1], goal = 2
 * Output: 4
 * Explanation: The 4 subarrays are bolded and underlined below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * Example 2:
 *
 * Input: nums = [0,0,0,0,0], goal = 0
 * Output: 15
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * nums[i] is either 0 or 1.
 * 0 <= goal <= nums.length
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.slidingwindow;


import java.util.HashMap;
import java.util.Map;

public class _930_Binary_Subarrays_With_Sum {

//    public int numSubarraysWithSum(int[] nums, int goal) {
//
//        // Using Map
//        int n = nums.length;
//        // Key = Sum; Value = freq
//        Map<Integer, Integer> map = new HashMap<>();
//        // Zero sum is 1 time
//        map.put(0, 1);
//        int result = 0;
//
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += nums[i];
//            int diff = sum - goal;
//
//            if (map.containsKey(diff)) {
//                result += map.get(diff);
//            }
//
//            map.put(sum, map.getOrDefault(sum, 0) + 1);
//        }
//
//        return result;
//    }

    public int numSubarraysWithSum(int[] nums, int goal) {

        // Sliding Window
        int n = nums.length;
        int result = 0;

        int i = 0;
        int j = 0;
        int sum = 0;
        int zeroCount = 0;
        while (j < n) {
            sum += nums[j];

            while (i < j && (nums[i] == 0 || sum > goal)) {

                if (nums[i] == 0) {
                    zeroCount++;
                } else {
                    zeroCount = 0;
                }

                sum -= nums[i];
                i++;
            }

            if (sum == goal) {
                result++;
                result += zeroCount;
            }

            j++;
        }

        return result;
    }
}

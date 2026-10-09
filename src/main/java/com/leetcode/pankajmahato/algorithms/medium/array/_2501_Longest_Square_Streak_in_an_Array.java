/**********************************************************************************
 *
 * https://leetcode.com/problems/longest-square-streak-in-an-array/
 *
 * You are given an integer array nums. A subsequence of nums is called a square streak if:
 *
 * The length of the subsequence is at least 2, and
 * after sorting the subsequence, each element (except the first element) is the square of the previous number.
 * Return the length of the longest square streak in nums, or return -1 if there is no square streak.
 *
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,6,16,8,2]
 * Output: 3
 * Explanation: Choose the subsequence [4,16,2]. After sorting it, it becomes [2,4,16].
 * - 4 = 2 * 2.
 * - 16 = 4 * 4.
 * Therefore, [4,16,2] is a square streak.
 * It can be shown that every subsequence of length 4 is not a square streak.
 * Example 2:
 *
 * Input: nums = [2,3,5,6,7]
 * Output: -1
 * Explanation: There is no square streak in nums so return -1.
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * 2 <= nums[i] <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.HashSet;
import java.util.Set;

public class _2501_Longest_Square_Streak_in_an_Array {

    // public int longestSquareStreak(int[] nums) {

    //     int n = nums.length;

    //     Arrays.sort(nums);

    //     // Starting Number -> streak length
    //     Map<Integer, Integer> map = new HashMap<>();
    //     int result = 0;

    //     for (int i = 0; i < n; i++) {
    //         int num = nums[i];
    //         int sqrt = (int) (Math.sqrt(num));
    //         if (sqrt * sqrt == num && map.containsKey(sqrt)) {
    //             map.put(num, map.get(sqrt) + 1);
    //             result = Math.max(result, map.get(num));
    //         } else {
    //             map.put(num, 1);
    //         }

    //     }

    //     return result == 0 ? -1 : result;
    // }

    public int longestSquareStreak(int[] nums) {

        int n = nums.length;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;

        for (int num : nums) {
            long curr = num;
            int streak = 0;
            while (set.contains((int) curr)) {
                streak++;
                curr = curr * curr;

                // Number constraints for Integer
                if (curr > 1e5) {
                    break;
                }
            }

            result = Math.max(result, streak);
        }

        return result < 2 ? -1 : result;
    }
}

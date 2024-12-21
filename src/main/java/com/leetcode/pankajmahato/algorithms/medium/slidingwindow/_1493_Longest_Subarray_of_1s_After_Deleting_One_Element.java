/**********************************************************************************
 *
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 *
 * Given a binary array nums, you should delete one element from it.
 *
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 * Example 2:
 *
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 * Example 3:
 *
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.slidingwindow;


public class _1493_Longest_Subarray_of_1s_After_Deleting_One_Element {

//    public int longestSubarray(int[] nums) {
//
//        int n = nums.length;
//        int zeroCount = 0;
//        int result = 0;
//        int i = 0;
//        int j = 0;
//
//        while (j < n) {
//
//            if (nums[j] == 0) {
//                zeroCount++;
//            }
//
//            while (zeroCount > 1) {
//
//                if (nums[i] == 0) {
//                    zeroCount--;
//                }
//                i++;
//            }
//            result = Math.max(result, j - i);
//            j++;
//        }
//
//        return result;
//    }

    public int longestSubarray(int[] nums) {

        // Optimised
        int n = nums.length;
        int lastZeroIdx = -1;
        int result = 0;
        int i = 0;
        int j = 0;

        while (j < n) {

            if (nums[j] == 0) {
                i = lastZeroIdx + 1;
                lastZeroIdx = j;
            }
            result = Math.max(result, j - i);
            j++;
        }

        return result;
    }
}

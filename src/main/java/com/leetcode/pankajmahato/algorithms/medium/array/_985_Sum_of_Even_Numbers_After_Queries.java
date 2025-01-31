/**********************************************************************************
 *
 * https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 *
 * You are given an integer array nums and an array queries where queries[i] = [vali, indexi].
 *
 * For each query i, first, apply nums[indexi] = nums[indexi] + vali, then print the sum of the even values of nums.
 *
 * Return an integer array answer where answer[i] is the answer to the ith query.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 * Explanation: At the beginning, the array is [1,2,3,4].
 * After adding 1 to nums[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to nums[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
 * After adding -4 to nums[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
 * After adding 2 to nums[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 * Example 2:
 *
 * Input: nums = [1], queries = [[4,0]]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * 1 <= queries.length <= 104
 * -104 <= vali <= 104
 * 0 <= indexi < nums.length
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _985_Sum_of_Even_Numbers_After_Queries {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

        int n = nums.length;
        int q = queries.length;

        int evenSum = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                evenSum += num;
            }
        }

        int[] result = new int[q];
        for (int i = 0; i < q; i++) {
            int idx = queries[i][1];
            int val = queries[i][0];

            if (nums[idx] % 2 == 0) {
                evenSum -= nums[idx];
            }
            nums[idx] += val;
            if (nums[idx] % 2 == 0) {
                evenSum += nums[idx];
            }
            result[i] = evenSum;
        }

        return result;
    }
}

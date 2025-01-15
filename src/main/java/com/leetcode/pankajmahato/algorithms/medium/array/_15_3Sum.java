/**********************************************************************************
 *
 * https://leetcode.com/problems/3sum/
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation: 
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {

        // n1 + n2 + n3 = 0
        // -n1 = n2 + n3

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        if (n < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            twoSum(nums, n, -nums[i], i + 1, n - 1, result);
        }

        return result;
    }

    private void twoSum(int[] nums, int n, int target, int i, int j, List<List<Integer>> result) {
        while (i < j) {

            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {

                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }

                while (i < j && nums[j] == nums[j - 1]) {
                    j--;
                }

                result.add(Arrays.asList(-target, nums[i], nums[j]));
                i++;
                j--;
            }
        }
    }
}

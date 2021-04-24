/**********************************************************************************
 *
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 *
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [1,1,2]
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: []
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * Each element in nums appears once or twice.
 *
 *
 * Follow up: Could you do it without extra space and in O(n) runtime?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

public class _442_Find_All_Duplicates_in_an_Array {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);

            if (nums[index - 1] < 0) {
                res.add(index);
            } else {
                nums[index - 1] *= -1;
            }
        }

        return res;
    }

}

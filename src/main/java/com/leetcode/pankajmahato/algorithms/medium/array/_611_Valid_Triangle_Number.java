/**********************************************************************************
 *
 * https://leetcode.com/problems/valid-triangle-number/
 *
 * Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,3,4]
 * Output: 3
 * Explanation: Valid combinations are: 
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Example 2:
 *
 * Input: nums = [4,2,3,4]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.Arrays;

public class _611_Valid_Triangle_Number {

    public int triangleNumber(int[] nums) {

        int n = nums.length;

        if (n < 3) {
            return 0;
        }

        Arrays.sort(nums);

        // After sorting we can check the triangle conditions. (a + b > c) && (a + c > b) && (b + c > a)
        // Array becomes -> [ ..., a, ..., b, ..., c, ...]
        // Due to sorting, (a + c > b) && (b + c > a) is always true
        // We have to find triplets which satisfy (a + b > c)

        int result = 0;

        for (int c = n - 1; c >= 2; c--) {

            int a = 0;
            int b = c - 1;
            while (a < b) {

                if (nums[a] + nums[b] > nums[c]) {
                    result = result + (b - a);
                    b--;
                } else {
                    a++;
                }
            }
        }

        return result;
    }
}

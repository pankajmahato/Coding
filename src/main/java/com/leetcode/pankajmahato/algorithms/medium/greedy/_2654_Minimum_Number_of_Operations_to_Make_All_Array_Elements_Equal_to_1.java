
/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/
 *
 * You are given a 0-indexed array nums consisting of positive integers. You can do the following operation on the array any number of times:
 *
 * Select an index i such that 0 <= i < n - 1 and replace either of nums[i] or nums[i+1] with their gcd value.
 * Return the minimum number of operations to make all elements of nums equal to 1. If it is impossible, return -1.
 *
 * The gcd of two integers is the greatest common divisor of the two integers.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,6,3,4]
 * Output: 4
 * Explanation: We can do the following operations:
 * - Choose index i = 2 and replace nums[2] with gcd(3,4) = 1. Now we have nums = [2,6,1,4].
 * - Choose index i = 1 and replace nums[1] with gcd(6,1) = 1. Now we have nums = [2,1,1,4].
 * - Choose index i = 0 and replace nums[0] with gcd(2,1) = 1. Now we have nums = [1,1,1,4].
 * - Choose index i = 2 and replace nums[3] with gcd(1,4) = 1. Now we have nums = [1,1,1,1].
 * Example 2:
 *
 * Input: nums = [2,10,6,14]
 * Output: -1
 * Explanation: It can be shown that it is impossible to make all the elements equal to 1.
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 50
 * 1 <= nums[i] <= 106
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.greedy;

public class _2654_Minimum_Number_of_Operations_to_Make_All_Array_Elements_Equal_to_1 {

    public int minOperations(int[] nums) {

        int n = nums.length;

        // Observation
        // Once we get 1 as the gcd we can convert each number in 1 operation
        int countOfOne = 0;

        for (int num : nums) {
            if (num == 1) {
                countOfOne++;
            }
        }

        if (countOfOne > 0) {
            return n - countOfOne;
        }

        // Find the 1 with min operations;
        int minOperations = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int currentGCD = nums[i];
            for (int j = i + 1; j < n; j++) {

                currentGCD = gcd(currentGCD, nums[j]);

                if (currentGCD == 1) {
                    minOperations = Math.min(minOperations, j - i);
                    break;
                }
            }
        }

        if (minOperations == Integer.MAX_VALUE) {
            return -1;
        }

        return minOperations + (n - 1);
    }

    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/prime-subtraction-operation/
 *
 * You are given a 0-indexed integer array nums of length n.
 *
 * You can perform the following operation as many times as you want:
 *
 * Pick an index i that you haven’t picked before, and pick a prime p strictly less than nums[i], then subtract p from nums[i].
 * Return true if you can make nums a strictly increasing array using the above operation and false otherwise.
 *
 * A strictly increasing array is an array whose each element is strictly greater than its preceding element.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,9,6,10]
 * Output: true
 * Explanation: In the first operation: Pick i = 0 and p = 3, and then subtract 3 from nums[0], so that nums becomes [1,9,6,10].
 * In the second operation: i = 1, p = 7, subtract 7 from nums[1], so nums becomes equal to [1,2,6,10].
 * After the second operation, nums is sorted in strictly increasing order, so the answer is true.
 * Example 2:
 *
 * Input: nums = [6,8,11,12]
 * Output: true
 * Explanation: Initially nums is sorted in strictly increasing order, so we don't need to make any operations.
 * Example 3:
 *
 * Input: nums = [5,8,3]
 * Output: false
 * Explanation: It can be proven that there is no way to perform operations to make nums sorted in strictly increasing order, so the answer is false.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * nums.length == n
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.Arrays;

public class _2601_Prime_Subtraction_Operation {

    public boolean primeSubOperation(int[] nums) {

        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        boolean[] primes = sieve(max);

        for (int i = n - 2; i >= 0; i--) {

            if (nums[i] < nums[i + 1]) {
                continue;
            }

            for (int p = 2; p < nums[i]; p++) {

                if (!primes[p]) {
                    continue;
                }

                if (nums[i] - p < nums[i + 1]) {
                    nums[i] = nums[i] - p;
                    break;
                }
            }

            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }

        return true;
    }

    private boolean[] sieve(int n) {

        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i * i <= n; i++) {

            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        return primes;
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/
 *
 * You are given an integer array nums.
 * A subsequence sub of nums with length x is called valid if it satisfies:
 *
 * (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
 * Return the length of the longest valid subsequence of nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 *
 * Output: 4
 *
 * Explanation:
 *
 * The longest valid subsequence is [1, 2, 3, 4].
 *
 * Example 2:
 *
 * Input: nums = [1,2,1,1,2,1,2]
 *
 * Output: 6
 *
 * Explanation:
 *
 * The longest valid subsequence is [1, 2, 1, 2, 1, 2].
 *
 * Example 3:
 *
 * Input: nums = [1,3]
 *
 * Output: 2
 *
 * Explanation:
 *
 * The longest valid subsequence is [1, 3].
 *
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 2 * 105
 * 1 <= nums[i] <= 107
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _3201_Find_the_Maximum_Length_of_Valid_Subsequence_I {

    public int maximumLength(int[] nums) {

        // Only 3 patterns satisfy the condition
        // 1. All even
        // 2. All odd
        // 3. Alternating parity ( ..., even, odd, even, odd, ...)

        int n = nums.length;

        int evenCount = 0;
        int oddCount = 0;
        int alternateCount = 0;

        // Flip the parity to count the 1st element for alternate
        int prevParity = 1 - nums[0] % 2;

        for (int i = 0; i < n; i++) {

            int parity = nums[i] % 2;

            if (parity == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

            if (prevParity != parity) {
                alternateCount++;
            }

            prevParity = parity;
        }

        return Math.max(evenCount, Math.max(oddCount, alternateCount));
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/find-unique-binary-string/
 *
 * Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = ["01","10"]
 * Output: "11"
 * Explanation: "11" does not appear in nums. "00" would also be correct.
 * Example 2:
 *
 * Input: nums = ["00","01"]
 * Output: "11"
 * Explanation: "11" does not appear in nums. "10" would also be correct.
 * Example 3:
 *
 * Input: nums = ["111","011","001"]
 * Output: "101"
 * Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 16
 * nums[i].length == n
 * nums[i] is either '0' or '1'.
 * All the strings of nums are unique.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.string;

public class _1980_Find_Unique_Binary_String {

    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;
        char[] result = new char[n];

        for (int i = 0; i < n; i++) {
            // Flip every i-th bit of i-th string to produce unique string
            result[i] = nums[i].charAt(i) == '0' ? '1' : '0';
        }

        return new String(result);
    }
}

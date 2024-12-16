/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 *
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,10,5,25,2,8]
 * Output: 28
 * Explanation: The maximum result is 5 XOR 25 = 28.
 * Example 2:
 *
 * Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * Output: 127
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 105
 * 0 <= nums[i] <= 231 - 1
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.trie;

public class _421_Maximum_XOR_of_Two_Numbers_in_an_Array {

    class TrieNode {
        TrieNode zero;
        TrieNode one;
    }

    private void insertTrieNode(TrieNode root, int num) {

        for (int i = 31; i >= 0; i--) {

            int ithBit = (num >> i) & 1;
            if (ithBit == 0) {
                if (root.zero == null) {
                    root.zero = new TrieNode();
                }
                root = root.zero;
            } else {
                if (root.one == null) {
                    root.one = new TrieNode();
                }
                root = root.one;
            }
        }
    }

    public int findMaximumXOR(int[] nums) {

        int n = nums.length;

        TrieNode root = new TrieNode();
        for (int i = 0; i < n; i++) {
            insertTrieNode(root, nums[i]);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            int num = findMaxXor(root, nums[i]);
            result = Math.max(result, num);
        }

        return result;
    }

    private int findMaxXor(TrieNode root, int num) {

        int result = 0;
        for (int i = 31; i >= 0; i--) {
            int ithBit = (num >> i) & 1;
            if (ithBit == 0) {
                if (root.one != null) {
                    // 0 ^ 1 = 2^i * 1
                    result = result + (int) Math.pow(2, i);
                    root = root.one;
                } else {
                    // 0 ^ 0 = 2^i * 0
                    root = root.zero;
                }
            } else {
                if (root.zero != null) {
                    // 1 ^ 0 = 2^i * 1
                    result = result + (int) Math.pow(2, i);
                    root = root.zero;
                } else {
                    // 1 ^ 1 = 2^i * 0
                    root = root.one;
                }
            }
        }

        return result;
    }
}

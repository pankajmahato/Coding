/**********************************************************************************
 *
 * https://leetcode.com/problems/binary-trees-with-factors/
 *
 * Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
 *
 * We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.
 *
 * Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,4]
 * Output: 3
 * Explanation: We can make these trees: [2], [4], [4, 2, 2]
 * Example 2:
 *
 * Input: arr = [2,4,5,10]
 * Output: 7
 * Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * 2 <= arr[i] <= 109
 * All the values of arr are unique.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _823_Binary_Trees_With_Factors {

    public int numFactoredBinaryTrees(int[] arr) {

        int MOD = (int) 1e9 + 7;
        int n = arr.length;

        // Key = number; Value = no. of binary trees
        Map<Integer, Long> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, 1L);
        }

        Arrays.sort(arr);

        long result = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                    long leftWays = map.get(arr[j]);
                    long rightWays = map.get(arr[i] / arr[j]);

                    long total = (map.get(arr[i]) + leftWays * rightWays) % MOD;
                    map.put(arr[i], total);
                }
            }
        }

        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            result = (result + entry.getValue()) % MOD;
        }

        return (int) result;
    }
}

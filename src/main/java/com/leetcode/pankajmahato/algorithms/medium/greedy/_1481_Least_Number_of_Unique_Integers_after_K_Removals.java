
/**********************************************************************************
 *
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 *
 * Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [5,5,4], k = 1
 * Output: 1
 * Explanation: Remove the single 4, only 5 is left.
 * Example 2:
 * Input: arr = [4,3,1,1,3,3,2], k = 3
 * Output: 2
 * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.greedy;

import java.util.HashMap;
import java.util.Map;

public class _1481_Least_Number_of_Unique_Integers_after_K_Removals {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        int n = arr.length;

        // num -> count
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Number of unique elements
        int uniqueElements = map.size();
        // freq[i] = number of elements -> number of unique elements having i frequency
        // freq[2] = 2 -> {.. ,1,1,4,4, ... } there are 2 unique elements having frequency 2, total number = 2 * 2
        int[] freqCount = new int[n + 1];
        for (int freq : map.values()) {
            freqCount[freq]++;
        }

        for (int freq = 1; freq < n + 1; freq++) {

            int numberOfUniqueCanBeDeleted = Math.min(k / freq, freqCount[freq]);

            k -= numberOfUniqueCanBeDeleted * freq;

            uniqueElements -= numberOfUniqueCanBeDeleted;

            if (k <= freq) {
                return uniqueElements;
            }
        }

        // All elements deleted
        return 0;
    }
}

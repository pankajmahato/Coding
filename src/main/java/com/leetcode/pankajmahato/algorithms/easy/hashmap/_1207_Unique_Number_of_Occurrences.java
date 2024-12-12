/**********************************************************************************
 *
 * https://leetcode.com/problems/unique-number-of-occurrences/
 *
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 *
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1207_Unique_Number_of_Occurrences {

    public boolean uniqueOccurrences(int[] arr) {

        int n = arr.length;

        // Key = number; Value = Occurance
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> occurenceSet = new HashSet<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (occurenceSet.contains(entry.getValue())) {
                return false;
            }
            occurenceSet.add(entry.getValue());
        }

        return true;
    }
}

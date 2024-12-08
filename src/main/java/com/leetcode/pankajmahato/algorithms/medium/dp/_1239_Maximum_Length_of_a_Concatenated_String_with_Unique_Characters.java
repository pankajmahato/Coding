/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 *
 * You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.
 *
 * Return the maximum possible length of s.
 *
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All the valid concatenations are:
 * - ""
 * - "un"
 * - "iq"
 * - "ue"
 * - "uniq" ("un" + "iq")
 * - "ique" ("iq" + "ue")
 * Maximum length is 4.
 * Example 2:
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * Explanation: The only string in arr has all 26 characters.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _1239_Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {

    public int maxLength(List<String> arr) {

        // DP with top down
        int n = arr.size();

        // Key = String; Value = MaxLength;
        Map<String, Integer> dp = new HashMap<>();

        StringBuilder temp = new StringBuilder();
        return solve(arr, n, 0, temp, dp);
    }

    private int solve(List<String> arr, int n, int idx, StringBuilder temp, Map<String, Integer> dp) {

        if (idx >= n) {
            return temp.length();
        }

        if (dp.containsKey(temp.toString())) {
            return dp.get(temp.toString());
        }

        // Exclude current element
        int exclude = solve(arr, n, idx + 1, temp, dp);

        // Include current element only if unique
        int include = 0;
        if (isUnique(temp, arr.get(idx))) {
            temp.append(arr.get(idx));
            include = solve(arr, n, idx + 1, temp, dp);
            temp.setLength(temp.length() - arr.get(idx).length());
        }

        dp.put(temp.toString(), Math.max(exclude, include));
        return dp.get(temp.toString());
    }

    private boolean isUnique(StringBuilder s1, String s2) {

        Set<Character> set = new HashSet<>();

        int i = 0;
        int j = 0;
        while (i < s1.length()) {
            if (set.contains(s1.charAt(i))) {
                return false;
            }
            set.add(s1.charAt(i));
            i++;
        }

        while (j < s2.length()) {
            if (set.contains(s2.charAt(j))) {
                return false;
            }
            set.add(s2.charAt(j));
            j++;
        }

        return true;
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/shortest-uncommon-substring-in-an-array/
 *
 * You are given an array arr of size n consisting of non-empty strings.
 *
 * Find a string array answer of size n such that:
 *
 * answer[i] is the shortest substring of arr[i] that does not occur as a substring in any other string in arr. If multiple such substrings exist, answer[i] should be the lexicographically smallest. And if no such substring exists, answer[i] should be an empty string.
 * Return the array answer.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = ["cab","ad","bad","c"]
 * Output: ["ab","","ba",""]
 * Explanation: We have the following:
 * - For the string "cab", the shortest substring that does not occur in any other string is either "ca" or "ab", we choose the lexicographically smaller substring, which is "ab".
 * - For the string "ad", there is no substring that does not occur in any other string.
 * - For the string "bad", the shortest substring that does not occur in any other string is "ba".
 * - For the string "c", there is no substring that does not occur in any other string.
 * Example 2:
 *
 * Input: arr = ["abc","bcd","abcd"]
 * Output: ["","","abcd"]
 * Explanation: We have the following:
 * - For the string "abc", there is no substring that does not occur in any other string.
 * - For the string "bcd", there is no substring that does not occur in any other string.
 * - For the string "abcd", the shortest substring that does not occur in any other string is "abcd".
 *
 *
 * Constraints:
 *
 * n == arr.length
 * 2 <= n <= 100
 * 1 <= arr[i].length <= 20
 * arr[i] consists only of lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3076_Shortest_Uncommon_Substring_in_an_Array {

    public String[] shortestSubstrings(String[] arr) {

        int n = arr.length;

        // Count of all possible substrings for all strings
        Map<String, Integer> map = new HashMap<>();

        for (String str : arr) {

            Set<String> set = new HashSet<>();

            int m = str.length();
            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m + 1; j++) {
                    String curr = str.substring(i, j);
                    if (!set.contains(curr)) {
                        set.add(curr);
                        map.put(curr, map.getOrDefault(curr, 0) + 1);
                    }
                }
            }
        }

        String[] result = new String[n];

        for (int k = 0; k < n; k++) {
            String str = arr[k];
            String shortest = "";

            int m = str.length();
            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m + 1; j++) {

                    String curr = str.substring(i, j);

                    if (map.get(curr) == 1
                            && (shortest.length() == 0 || curr.length() < shortest.length()
                            || (curr.length() == shortest.length() && curr.compareTo(shortest) < 0))) {
                        shortest = curr;
                    }
                }
            }

            result[k] = shortest;
        }

        return result;
    }
}

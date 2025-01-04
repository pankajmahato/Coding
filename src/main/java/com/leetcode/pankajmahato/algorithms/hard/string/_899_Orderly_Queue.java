/**********************************************************************************
 *
 * https://leetcode.com/problems/orderly-queue/
 *
 * You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string.
 *
 * Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cba", k = 1
 * Output: "acb"
 * Explanation: 
 * In the first move, we move the 1st character 'c' to the end, obtaining the string "bac".
 * In the second move, we move the 1st character 'b' to the end, obtaining the final result "acb".
 * Example 2:
 *
 * Input: s = "baaca", k = 3
 * Output: "aaabc"
 * Explanation: 
 * In the first move, we move the 1st character 'b' to the end, obtaining the string "aacab".
 * In the second move, we move the 3rd character 'c' to the end, obtaining the final result "aaabc".
 *
 *
 * Constraints:
 *
 * 1 <= k <= s.length <= 1000
 * s consist of lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.string;

import java.util.Arrays;

public class _899_Orderly_Queue {

    public String orderlyQueue(String s, int k) {

        if (k > 1) {
            // "cba" -> "bac" -> "acb" -> "cba" -> ...
            // we only have N swaps here
            // as it will become the original string after N swaps
            // hence, we can try all N possible swaps and find the lexicographically
            // smallest one
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        }

        // if k > 1, we can move any character to any position by swapping two adjacent
        // characters
        // By swapping a number of times,
        // e.g. "cab"
        // eventually we could have "abc", "acb", "bca", "bac", "cba", "cab" (3 * 2 * 1
        // = 6 possible arrangements)
        // so the lexicographically smallest string would be the sorted string
        String result = s;
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i) + s.substring(0, i);
            if (result.compareTo(temp) > 0) {
                result = temp;
            }
        }

        return result;
    }
}

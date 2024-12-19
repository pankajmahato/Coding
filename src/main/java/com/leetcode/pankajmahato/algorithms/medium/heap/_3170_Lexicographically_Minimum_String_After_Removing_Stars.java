/**********************************************************************************
 *
 * https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/
 *
 * You are given a string s. It may contain any number of '*' characters. Your task is to remove all '*' characters.
 *
 * While there is a '*', do the following operation:
 *
 * Delete the leftmost '*' and the smallest non-'*' character to its left. If there are several smallest characters, you can delete any of them.
 * Return the 
 * lexicographically smallest
 *  resulting string after removing all '*' characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aaba*"
 *
 * Output: "aab"
 *
 * Explanation:
 *
 * We should delete one of the 'a' characters with '*'. If we choose s[3], s becomes the lexicographically smallest.
 *
 * Example 2:
 *
 * Input: s = "abc"
 *
 * Output: "abc"
 *
 * Explanation:
 *
 * There is no '*' in the string.
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists only of lowercase English letters and '*'.
 * The input is generated such that it is possible to delete all '*' characters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.heap;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _3170_Lexicographically_Minimum_String_After_Removing_Stars {

    public String clearStars(String s) {

        char[] arr = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            int val = Integer.compare(a[0], b[0]);
            if (val != 0) {
                return val;
            }

            return Integer.compare(b[1], a[1]);
        });

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '*') {
                int[] val = queue.remove();

                arr[val[1]] = '$';
                arr[i] = '$';
            } else {
                queue.add(new int[]{(int) arr[i], i});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '$') {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }
}

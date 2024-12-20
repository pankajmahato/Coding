/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window 
 * substring
 *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.slidingwindow;


import java.util.HashMap;
import java.util.Map;

public class _76_Minimum_Window_Substring {

    public String minWindow(String s, String t) {

        int n = s.length();
        int m = t.length();

        if (m > n) {
            return "";
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int requiredCount = m;
        int minWindowSize = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int startIdx = 0;

        while (j < n) {
            char ch = s.charAt(j);

            if (freqMap.getOrDefault(ch, -1) > 0) {
                requiredCount--;
            }

            freqMap.put(ch, freqMap.getOrDefault(ch, 0) - 1);

            while (requiredCount == 0) {

                int currentWindowSize = j - i + 1;

                if (minWindowSize > currentWindowSize) {
                    minWindowSize = currentWindowSize;
                    startIdx = i;
                }

                char startCh = s.charAt(i);
                freqMap.put(startCh, freqMap.getOrDefault(startCh, 0) + 1);

                if (freqMap.getOrDefault(startCh, -1) > 0) {
                    requiredCount++;
                }
                i++;
            }

            j++;
        }

        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minWindowSize);
    }
}

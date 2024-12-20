/**********************************************************************************
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * Given two strings s and p, return an array of all the start indices of p's 
 * anagrams
 *  in s. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.slidingwindow;


import java.util.ArrayList;
import java.util.List;

public class _438_Find_All_Anagrams_in_a_String {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int n = s.length();
        int k = p.length();
        int[] freq = new int[26];
        for (int i = 0; i < k; i++) {
            freq[p.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = 0;
        while (j < n) {

            freq[s.charAt(j) - 'a']--;

            if (j - i + 1 == k) {
                if (isAllZero(freq)) {
                    result.add(i);
                }

                freq[s.charAt(i) - 'a']++;
                i++;
            }

            j++;
        }

        return result;
    }

    private boolean isAllZero(int[] freq) {

        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}

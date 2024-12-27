/**********************************************************************************
 *
 * https://leetcode.com/problems/permutation-in-string/
 *
 * Given two strings s1 and s2, return true if s2 contains a 
 * permutation
 *  of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.slidingwindow;


public class _567_Permutation_in_String {

    public boolean checkInclusion(String s1, String s2) {

        int N = 26;
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) {
            return false;
        }

        // Freq map of S1
        int[] s1Map = new int[N];
        // Freq map of S2
        int[] s2Map = new int[N];

        // Store freq of s1
        for (int i = 0; i < n1; i++) {
            s1Map[s1.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = 0;

        while (j < n2) {

            s2Map[s2.charAt(j) - 'a']++;

            if (j - i + 1 > n1) {
                s2Map[s2.charAt(i) - 'a']--;
                i++;
            }

            if (compareFreqMap(N, s1Map, s2Map) == true) {
                return true;
            }

            j++;
        }

        return false;
    }

    private boolean compareFreqMap(int N, int[] s1, int[] s2) {

        for (int i = 0; i < N; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }

        return true;
    }
}

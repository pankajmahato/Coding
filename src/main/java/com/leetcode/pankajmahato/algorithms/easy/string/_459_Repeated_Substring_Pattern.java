
/**********************************************************************************
 *
 * https://leetcode.com/problems/repeated-substring-pattern/
 *
 * Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 * Example 2:
 *
 * Input: s = "aba"
 * Output: false
 * Example 3:
 *
 * Input: s = "abcabcabcabc"
 * Output: true
 * Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.string;

public class _459_Repeated_Substring_Pattern {

    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();
        for (int l = n / 2; l >= 1; l--) {

            if (n % l == 0) {

                String sub = s.substring(0, l);
                StringBuilder repeated = new StringBuilder();
                int times = n / l;
                while (times-- > 0) {
                    repeated.append(sub);
                }

                if (repeated.toString().equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }
}

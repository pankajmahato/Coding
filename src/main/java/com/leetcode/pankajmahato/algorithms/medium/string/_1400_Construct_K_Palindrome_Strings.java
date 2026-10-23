/**********************************************************************************
 *
 * https://leetcode.com/problems/construct-k-palindrome-strings/
 *
 * Given a string s and an integer k, return true if you can use all the characters in s to construct non-empty k palindrome strings or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "annabelle", k = 2
 * Output: true
 * Explanation: You can construct two palindromes using all characters in s.
 * Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"
 * Example 2:
 *
 * Input: s = "leetcode", k = 3
 * Output: false
 * Explanation: It is impossible to construct 3 palindromes using all the characters of s.
 * Example 3:
 *
 * Input: s = "true", k = 4
 * Output: true
 * Explanation: The only possible solution is to put each character in a separate string.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * 1 <= k <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.string;

public class _1400_Construct_K_Palindrome_Strings {

    public boolean canConstruct(String s, int k) {

        // Observation
        // Even freq of chars can be used to create palindromes
        // Minimum number of palindromes = Odd freq count

        int N = 26;
        int n = s.length();

        if (n < k) {
            return false;
        }

        int[] freq = new int[N];

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int oddCount = 0;

        for (int i = 0; i < N; i++) {

            if (freq[i] % 2 == 1) {
                oddCount++;
            }
        }

        if (oddCount > k) {
            return false;
        } else {
            return true;
        }
    }
}

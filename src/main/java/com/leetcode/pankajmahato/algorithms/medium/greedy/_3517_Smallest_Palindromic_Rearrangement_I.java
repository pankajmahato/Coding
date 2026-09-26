
/**********************************************************************************
 *
 * https://leetcode.com/problems/smallest-palindromic-rearrangement-i/
 *
 * You are given a palindromic string s.
 *
 * Return the lexicographically smallest palindromic permutation of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "z"
 *
 * Output: "z"
 *
 * Explanation:
 *
 * A string of only one character is already the lexicographically smallest palindrome.
 *
 * Example 2:
 *
 * Input: s = "babab"
 *
 * Output: "abbba"
 *
 * Explanation:
 *
 * Rearranging "babab" → "abbba" gives the smallest lexicographic palindrome.
 *
 * Example 3:
 *
 * Input: s = "daccad"
 *
 * Output: "acddca"
 *
 * Explanation:
 *
 * Rearranging "daccad" → "acddca" gives the smallest lexicographic palindrome.
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * s is guaranteed to be palindromic.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.greedy;

public class _3517_Smallest_Palindromic_Rearrangement_I {

    public String smallestPalindrome(String s) {

        int N = 26;

        int freq[] = new int[N];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder mid = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int count = freq[i];

            if (count % 2 == 1) {
                mid.append((char) (i + 'a'));
                count--;
            }
            count = count / 2;
            while (count-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }

        StringBuilder right = new StringBuilder(sb).reverse();
        sb.append(mid);

        return sb.append(right).toString();
    }
}

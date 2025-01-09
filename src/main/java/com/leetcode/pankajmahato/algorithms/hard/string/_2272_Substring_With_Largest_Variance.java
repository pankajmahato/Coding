/**********************************************************************************
 *
 * https://leetcode.com/problems/substring-with-largest-variance/
 *
 * The variance of a string is defined as the largest difference between the number of occurrences of any 2 characters present in the string. Note the two characters may or may not be the same.
 *
 * Given a string s consisting of lowercase English letters only, return the largest variance possible among all substrings of s.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aababbb"
 * Output: 3
 * Explanation:
 * All possible variances along with their respective substrings are listed below:
 * - Variance 0 for substrings "a", "aa", "ab", "abab", "aababb", "ba", "b", "bb", and "bbb".
 * - Variance 1 for substrings "aab", "aba", "abb", "aabab", "ababb", "aababbb", and "bab".
 * - Variance 2 for substrings "aaba", "ababbb", "abbb", and "babb".
 * - Variance 3 for substring "babbb".
 * Since the largest possible variance is 3, we return it.
 * Example 2:
 *
 * Input: s = "abcde"
 * Output: 0
 * Explanation:
 * No letter occurs more than once in s, so the variance of every substring is 0.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.string;

public class _2272_Substring_With_Largest_Variance {

    public int largestVariance(String s) {

        int N = 26;
        int[] freq = new int[N];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int result = 0;
        for (char first = 'a'; first <= 'z'; first++) {
            for (char second = 'a'; second <= 'z'; second++) {

                // Skip if any char is missing in original string
                if (first == second || freq[first - 'a'] == 0 || freq[second - 'a'] == 0) {
                    continue;
                }
                boolean seenSecondInPast = false;
                int firstFreq = 0;
                int secondFreq = 0;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == first) {
                        firstFreq++;
                    }
                    if (s.charAt(i) == second) {
                        secondFreq++;
                    }

                    if (secondFreq > 0) {
                        result = Math.max(result, firstFreq - secondFreq);
                    } else {
                        if (seenSecondInPast == true) {
                            result = Math.max(result, firstFreq - 1);
                        }
                    }

                    if (secondFreq > firstFreq) {
                        firstFreq = 0;
                        secondFreq = 0;
                        seenSecondInPast = true;
                    }
                }
            }
        }

        return result;
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 *
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.slidingwindow;


public class _1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {

    public int maxVowels(String s, int k) {

        int n = s.length();

        int i = 0;
        int j = 0;
        int maxVowelCount = 0;
        int currVowelCount = 0;

        while (j < n) {
            if (isVowel(s.charAt(j))) {
                currVowelCount++;
            }

            if (j - i + 1 == k) {
                maxVowelCount = Math.max(maxVowelCount, currVowelCount);

                if (isVowel(s.charAt(i))) {
                    currVowelCount--;
                }

                i++;
            }

            j++;
        }

        return maxVowelCount;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

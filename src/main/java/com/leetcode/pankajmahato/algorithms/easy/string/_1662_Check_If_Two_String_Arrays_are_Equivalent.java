/**********************************************************************************
 *
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 *
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 *
 * A string is represented by an array if the array elements concatenated in order forms the string.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 * Output: true
 * Explanation:
 * word1 represents string "ab" + "c" -> "abc"
 * word2 represents string "a" + "bc" -> "abc"
 * The strings are the same, so return true.
 * Example 2:
 *
 * Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
 * Output: false
 * Example 3:
 *
 * Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 103
 * 1 <= word1[i].length, word2[i].length <= 103
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * word1[i] and word2[i] consist of lowercase letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.string;

public class _1662_Check_If_Two_String_Arrays_are_Equivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        int n1 = word1.length;
        int n2 = word2.length;
        int word1Idx = 0;
        int word2Idx = 0;
        int i = 0;
        int j = 0;

        while (word1Idx < n1 && word2Idx < n2) {

            if (word1[word1Idx].charAt(i) != word2[word2Idx].charAt(j)) {
                return false;
            }

            i++;
            j++;

            // Reset i-th index of word in word1
            if (i == word1[word1Idx].length()) {
                i = 0;
                word1Idx++;
            }

            // Reset j-th index of word in word2
            if (j == word2[word2Idx].length()) {
                j = 0;
                word2Idx++;
            }
        }

        if (word1Idx == n1 && word2Idx == n2) {
            return true;
        } else {
            return false;
        }
    }
}


/**********************************************************************************
 *
 * https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/
 *
 * You are given two strings word1 and word2.
 *
 * A string x is called almost equal to y if you can change at most one character in x to make it identical to y.
 *
 * A sequence of indices seq is called valid if:
 *
 * The indices are sorted in ascending order.
 * Concatenating the characters at these indices in word1 in the same order results in a string that is almost equal to word2.
 * Return an array of size word2.length representing the lexicographically smallest valid sequence of indices. If no such sequence of indices exists, return an empty array.
 *
 * Note that the answer must represent the lexicographically smallest array, not the corresponding string formed by those indices.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "vbcca", word2 = "abc"
 *
 * Output: [0,1,2]
 *
 * Explanation:
 *
 * The lexicographically smallest valid sequence of indices is [0, 1, 2]:
 *
 * Change word1[0] to 'a'.
 * word1[1] is already 'b'.
 * word1[2] is already 'c'.
 * Example 2:
 *
 * Input: word1 = "bacdc", word2 = "abc"
 *
 * Output: [1,2,4]
 *
 * Explanation:
 *
 * The lexicographically smallest valid sequence of indices is [1, 2, 4]:
 *
 * word1[1] is already 'a'.
 * Change word1[2] to 'b'.
 * word1[4] is already 'c'.
 * Example 3:
 *
 * Input: word1 = "aaaaaa", word2 = "aaabc"
 *
 * Output: []
 *
 * Explanation:
 *
 * There is no valid sequence of indices.
 *
 * Example 4:
 *
 * Input: word1 = "abc", word2 = "ab"
 *
 * Output: [0,1]
 *
 *
 *
 * Constraints:
 *
 * 1 <= word2.length < word1.length <= 3 * 105
 * word1 and word2 consist only of lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.greedy;

import java.util.Arrays;

public class _3302_Find_the_Lexicographically_Smallest_Valid_Sequence {

    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // last[j] stores the maximum index in word1 where word2[j] can be matched
        // when matching word2[j...m-1] backwards with 0 modifications.
        int[] last = new int[m];

        int i = n - 1;
        int j = m - 1;
        while (i >= 0 && j >= 0) {
            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }
            i--;
        }
        System.out.println(Arrays.toString(last));
        int[] result = new int[m];

        int size = 0;
        boolean canModify = true;
        j = 0;

        for (i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                result[size++] = i;
                j++;
            } else if (canModify == true && (j == m - 1 || i < last[j + 1])) {
                // If i < last[j + 1], then after using i as the mismatching character
                // I still have a position at last[j + 1] available for the next character of word2
                // and the rest of the suffix can continue to be matched
                canModify = false;
                result[size++] = i;
                j++;
            }
        }

        if (j == m) {
            return result;
        }

        return new int[0];
    }
}

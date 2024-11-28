/**********************************************************************************
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 *
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "IceCreAm"
 *
 * Output: "AceCreIm"
 *
 * Explanation:
 *
 * The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
 *
 * Example 2:
 *
 * Input: s = "leetcode"
 *
 * Output: "leotcede"
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.twopointer;

public class _345_Reverse_Vowels_of_a_String {

    public String reverseVowels(String s) {

        char[] result = s.toCharArray();
        int i = 0;
        int j = result.length - 1;

        while (i <= j) {
            if (!isVowel(Character.toLowerCase(result[i]))) {
                i++;
            } else if (!isVowel(Character.toLowerCase(result[j]))) {
                j--;
            } else {
                char temp = result[i];
                result[i] = result[j];
                result[j] = temp;
                i++;
                j--;
            }
        }

        return new String(result);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

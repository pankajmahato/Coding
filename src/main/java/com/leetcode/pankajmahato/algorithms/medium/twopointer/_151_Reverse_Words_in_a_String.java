/**********************************************************************************
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Example 4:
 *
 * Input: s = "  Bob    Loves  Alice   "
 * Output: "Alice Loves Bob"
 * Example 5:
 *
 * Input: s = "Alice does not even like bob"
 * Output: "bob like even not does Alice"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 *
 *
 * Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.twopointer;

public class _151_Reverse_Words_in_a_String {

    public String reverseWords(String s) {

        // This is for in-place reversing
        char[] arr = s.toCharArray();

        int n = arr.length;

        // Reverse the complete string
        reverse(arr, 0, n - 1);

        int i = 0;
        int l = 0;
        int r = 0;

        while (i < n) {
            while (i < n && arr[i] != ' ') {
                arr[r] = arr[i];
                i++;
                r++;
            }

            // Reverse the word
            if (l < r) {
                reverse(arr, l, r - 1);
                // Add space only if it is inbounds
                if (r < n) {
                    arr[r] = ' ';
                }
                r++;
                l = r;
            }

            i++;
        }

        return new String(arr, 0, r - 1);
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}

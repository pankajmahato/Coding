/**********************************************************************************
 *
 * https://leetcode.com/problems/backspace-string-compare/
 *
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 *
 *
 * Follow up: Can you solve it in O(n) time and O(1) space?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.string;

public class _844_Backspace_String_Compare {

    public boolean backspaceCompare(String s, String t) {

        int n1 = s.length();
        int n2 = t.length();
        int i = n1 - 1;
        int j = n2 - 1;

        while (i >= 0 || j >= 0) {

            int skipS = 0;
            while (i >= 0) {

                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            int skipT = 0;
            while (j >= 0) {

                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            char source = i < 0 ? '$' : s.charAt(i);
            char target = j < 0 ? '$' : t.charAt(j);

            if (source != target) {
                return false;
            }
            i--;
            j--;
        }

        return true;
    }
}

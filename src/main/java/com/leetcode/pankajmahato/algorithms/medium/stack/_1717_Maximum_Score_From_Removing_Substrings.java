/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-score-from-removing-substrings/
 *
 * You are given a string s and two integers x and y. You can perform two types of operations any number of times.
 *
 * Remove substring "ab" and gain x points.
 * For example, when removing "ab" from "cabxbae" it becomes "cxbae".
 * Remove substring "ba" and gain y points.
 * For example, when removing "ba" from "cabxbae" it becomes "cabxe".
 * Return the maximum points you can gain after applying the above operations on s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cdbcbbaaabab", x = 4, y = 5
 * Output: 19
 * Explanation:
 * - Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
 * - Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
 * - Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
 * - Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
 * Total score = 5 + 4 + 5 + 5 = 19.
 * Example 2:
 *
 * Input: s = "aabbaaxybbaabb", x = 5, y = 4
 * Output: 20
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * 1 <= x, y <= 104
 * s consists of lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.stack;

public class _1717_Maximum_Score_From_Removing_Substrings {

    public int maximumGain(String s, int x, int y) {

        String maxStr;
        int maxNum;
        String minStr;
        int minNum;
        if (x > y) {
            maxStr = "ab";
            maxNum = x;
            minStr = "ba";
            minNum = y;
        } else {
            maxStr = "ba";
            maxNum = y;
            minStr = "ab";
            minNum = x;
        }

        int score = 0;
        StringBuilder temp = new StringBuilder(s);

        score = removeStr(temp, maxStr) * maxNum;

        score += removeStr(temp, minStr) * minNum;

        return score;
    }

    private int removeStr(StringBuilder s, String remove) {

        int i = 0;
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            s.setCharAt(i, s.charAt(j));
            i++;
            if (i > 1 && s.charAt(i - 2) == remove.charAt(0) && s.charAt(i - 1) == remove.charAt(1)) {
                i = i - 2;
                count++;
            }
        }

        s.setLength(i);
        return count;
    }
}

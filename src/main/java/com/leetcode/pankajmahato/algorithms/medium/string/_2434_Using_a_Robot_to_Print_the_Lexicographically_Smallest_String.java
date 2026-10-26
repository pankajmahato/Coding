/**********************************************************************************
 *
 * https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/
 *
 * You are given a string s and a robot that currently holds an empty string t. Apply one of the following operations until s and t are both empty:
 *
 * Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
 * Remove the last character of a string t and give it to the robot. The robot will write this character on paper.
 * Return the lexicographically smallest string that can be written on the paper.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "zza"
 * Output: "azz"
 * Explanation: Let p denote the written string.
 * Initially p="", s="zza", t="".
 * Perform first operation three times p="", s="", t="zza".
 * Perform second operation three times p="azz", s="", t="".
 * Example 2:
 *
 * Input: s = "bac"
 * Output: "abc"
 * Explanation: Let p denote the written string.
 * Perform first operation twice p="", s="c", t="ba". 
 * Perform second operation twice p="ab", s="c", t="". 
 * Perform first operation p="ab", s="", t="c". 
 * Perform second operation p="abc", s="", t="".
 * Example 3:
 *
 * Input: s = "bdda"
 * Output: "addb"
 * Explanation: Let p denote the written string.
 * Initially p="", s="bdda", t="".
 * Perform first operation four times p="", s="", t="bdda".
 * Perform second operation four times p="addb", s="", t="".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only English lowercase letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.string;

public class _2434_Using_a_Robot_to_Print_the_Lexicographically_Smallest_String {

    public String robotWithString(String s) {

        int n = s.length();

        char[] minCharRight = new char[n];

        minCharRight[n - 1] = s.charAt(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            minCharRight[i] = (char) Math.min(minCharRight[i + 1], s.charAt(i));
        }

        char[] stack = new char[n];
        int top = 0;
        StringBuilder paper = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            stack[top++] = s.charAt(i);

            char minChar = i + 1 < n ? minCharRight[i + 1] : s.charAt(i);

            while (top > 0 && stack[top - 1] <= minChar) {
                paper.append(stack[--top]);
            }
        }

        while (top > 0) {
            paper.append(stack[--top]);
        }

        return paper.toString();
    }
}

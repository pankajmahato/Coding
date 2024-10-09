/**********************************************************************************
 *
 * https://leetcode.com/problems/decode-string/
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never exceed 105.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _394_Decode_String {
    public String decodeString(String s) {
        List<Character> stack = new ArrayList<>();

        if (s.length() == 0) {
            return "";
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.add(s.charAt(i));
            } else {
                String temp = "";
                while (!stack.isEmpty() && stack.get(stack.size() - 1) != '[') {
                    temp = stack.remove(stack.size() - 1) + temp;
                }
                stack.remove(stack.size() - 1);
                String num = "";
                while (!stack.isEmpty() && Character.isDigit(stack.get(stack.size() - 1))) {
                    num = stack.remove(stack.size() - 1) + num;
                }
                int k = Integer.parseInt(num);
                for (int rep = 0; rep < k; rep++) {
                    for (int j = 0; j < temp.length(); j++) {
                        stack.add(temp.charAt(j));
                    }
                }
            }
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(new _394_Decode_String().decodeString("3[a2[c]]"));
    }

}

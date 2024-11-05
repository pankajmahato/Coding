/**********************************************************************************
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _17_Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {

        char[][] T9 = new char[][]{
                {' '},
                {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };

        ArrayList<String> result = new ArrayList<>();
        getLetterCombinations(T9, digits, result, "");

        return result;
    }

    private void getLetterCombinations(char[][] T9, String digits, List<String> result, String currResult) {

        if (digits.equals("")) {
            if (!currResult.equals("")) {
                result.add(currResult);
            }
            return;
        }

        String remDigits = digits.substring(1);
        int curr = digits.charAt(0) - '0';

        for (Character c : T9[curr]) {
            getLetterCombinations(T9, remDigits, result, currResult + c);
        }
    }
}

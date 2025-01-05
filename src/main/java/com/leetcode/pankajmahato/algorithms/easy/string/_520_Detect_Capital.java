/**********************************************************************************
 *
 * https://leetcode.com/problems/detect-capital/
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Given a string word, return true if the usage of capitals in it is right.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "USA"
 * Output: true
 * Example 2:
 *
 * Input: word = "FlaG"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 100
 * word consists of lowercase and uppercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.string;

public class _520_Detect_Capital {

    public boolean detectCapitalUse(String word) {

        int n = word.length();

        int capCount = 0;

        for (int i = 0; i < n; i++) {

            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                capCount++;
            }
        }

        if (capCount == 0 || capCount == n || (capCount == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')) {
            return true;
        }

        return false;
    }
}

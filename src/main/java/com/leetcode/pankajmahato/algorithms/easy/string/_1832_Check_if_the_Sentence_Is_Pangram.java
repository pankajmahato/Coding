/**********************************************************************************
 *
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 *
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 *
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English alphabet.
 * Example 2:
 *
 * Input: sentence = "leetcode"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= sentence.length <= 1000
 * sentence consists of lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.string;

public class _1832_Check_if_the_Sentence_Is_Pangram {

    public boolean checkIfPangram(String sentence) {

        if (sentence.length() < 26) {
            return false;
        }
        int[] freq = new int[26];
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            int idx = sentence.charAt(i) - 'a';
            freq[idx]++;
            if (freq[idx] == 1) {
                count++;
            }
        }

        return count == 26;
    }
}

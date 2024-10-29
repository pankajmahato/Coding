/**********************************************************************************
 *
 * https://leetcode.com/problems/word-break-ii/
 *
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 * Example 2:
 *
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 * Input is generated in a way that the length of the answer doesn't exceed 105.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard;

import java.util.ArrayList;
import java.util.List;

public class _140_Word_Break_II {

    List<String> result = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> temp = new ArrayList<>();

        backtrack(s, 0, wordDict, temp);
        return result;
    }

    private void backtrack(String s, int idx, List<String> wordDict, List<String> temp) {

        if (idx == s.length()) {
            result.add(String.join(" ", temp));
        }

        for (String dict : wordDict) {
            int i = idx;
            int j = 0;
            while (i < s.length() && j < dict.length()) {
                if (dict.charAt(j) != s.charAt(i)) {
                    break;
                }
                i++;
                j++;
            }
            if (j == dict.length()) {
                temp.add(dict);
                backtrack(s, idx + dict.length(), wordDict, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

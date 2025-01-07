/**********************************************************************************
 *
 * https://leetcode.com/problems/concatenated-words/
 *
 * Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
 *
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words (not necessarily distinct) in the given array.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * Example 2:
 *
 * Input: words = ["cat","dog","catdog"]
 * Output: ["catdog"]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 104
 * 1 <= words[i].length <= 30
 * words[i] consists of only lowercase English letters.
 * All the strings of words are unique.
 * 1 <= sum(words[i].length) <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _472_Concatenated_Words {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Set<String> set = new HashSet<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();
        Map<String, Boolean> dp = new HashMap<>();

        for (String word : words) {
            if (isConcatenatedWords(word, set, dp)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean isConcatenatedWords(String word, Set<String> set, Map<String, Boolean> dp) {

        if (dp.get(word) != null) {
            return dp.get(word);
        }

        for (int i = 0; i < word.length(); i++) {
            String prefix = word.substring(0, i + 1);
            String suffix = word.substring(i + 1, word.length());

            if (set.contains(prefix) && set.contains(suffix)) {
                dp.put(word, true);
                return true;
            }

            if (set.contains(prefix) && isConcatenatedWords(suffix, set, dp)) {
                dp.put(word, true);
                return true;
            }
        }

        dp.put(word, false);
        return false;
    }
}

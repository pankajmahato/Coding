/**********************************************************************************
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/
 *
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 105
 * s consists of uppercase and lowercase English letters and digits.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.heap;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _451_Sort_Characters_By_Frequency {
    
    public String frequencySort(String s) {

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue()));

        Map<Character, Integer> charFreq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
        }

        maxHeap.addAll(charFreq.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.remove();
            for (int i = entry.getValue() - 1; i >= 0; i--) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}

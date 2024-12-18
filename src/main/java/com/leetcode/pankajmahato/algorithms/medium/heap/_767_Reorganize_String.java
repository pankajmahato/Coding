/**********************************************************************************
 *
 * https://leetcode.com/problems/reorganize-string/
 *
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
 *
 * Return any possible rearrangement of s or return "" if not possible.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: "aba"
 * Example 2:
 *
 * Input: s = "aaab"
 * Output: ""
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.heap;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _767_Reorganize_String {

    class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String reorganizeString(String s) {

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // If the max(or any) frequency is more than ceil(n/2) then not possible
            if (map.get(ch) > (s.length() + 1) / 2) {
                return "";
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(new Pair(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1) {

            Pair first = queue.remove();
            Pair second = queue.remove();
            sb.append(first.ch);
            sb.append(second.ch);

            first.freq--;
            second.freq--;

            if (first.freq > 0) {
                queue.add(first);
            }
            if (second.freq > 0) {
                queue.add(second);
            }
        }

        if (!queue.isEmpty()) {
            sb.append(queue.peek().ch);
        }

        return sb.toString();
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/longest-happy-string/
 *
 * A string s is called happy if it satisfies the following conditions:
 *
 * s only contains the letters 'a', 'b', and 'c'.
 * s does not contain any of "aaa", "bbb", or "ccc" as a substring.
 * s contains at most a occurrences of the letter 'a'.
 * s contains at most b occurrences of the letter 'b'.
 * s contains at most c occurrences of the letter 'c'.
 * Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = 1, b = 1, c = 7
 * Output: "ccaccbcc"
 * Explanation: "ccbccacc" would also be a correct answer.
 * Example 2:
 *
 * Input: a = 7, b = 1, c = 0
 * Output: "aabaa"
 * Explanation: It is the only correct answer in this case.
 *
 *
 * Constraints:
 *
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.heap;


import java.util.PriorityQueue;

public class _1405_Longest_Happy_String {

    class Pair {

        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y.freq, x.freq));

        StringBuilder sb = new StringBuilder();

        if (a > 0) {
            maxHeap.add(new Pair('a', a));
        }
        if (b > 0) {
            maxHeap.add(new Pair('b', b));
        }
        if (c > 0) {
            maxHeap.add(new Pair('c', c));
        }

        while (!maxHeap.isEmpty()) {

            Pair curr = maxHeap.remove();

            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == curr.ch && sb.charAt(sb.length() - 2) == curr.ch) {

                if (maxHeap.isEmpty()) {
                    break;
                }

                Pair next = maxHeap.remove();
                sb.append(next.ch);
                next.freq--;

                if (next.freq > 0) {
                    maxHeap.add(next);
                }
            } else {
                curr.freq--;
                sb.append(curr.ch);
            }
            if (curr.freq > 0) {
                maxHeap.add(curr);
            }
        }

        return sb.toString();
    }
}

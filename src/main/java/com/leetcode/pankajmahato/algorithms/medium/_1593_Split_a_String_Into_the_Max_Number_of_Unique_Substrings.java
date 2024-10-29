
/**********************************************************************************
 *
 * https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
 *
 * Given a string s, return the maximum number of unique substrings that the given string can be split into.
 *
 * You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ababccc"
 * Output: 5
 * Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc']. Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.
 * Example 2:
 *
 * Input: s = "aba"
 * Output: 2
 * Explanation: One way to split maximally is ['a', 'ba'].
 * Example 3:
 *
 * Input: s = "aa"
 * Output: 1
 * Explanation: It is impossible to split the string any further.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 16
 *
 * s contains only lower case English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;

import java.util.HashSet;
import java.util.Set;

public class _1593_Split_a_String_Into_the_Max_Number_of_Unique_Substrings {
    int total = 0;

    public int maxUniqueSplit(String s) {

        Set<String> temp = new HashSet<>();

        backtrack(s, 0, temp, 0);
        return total;
    }

    private void backtrack(String s, int idx, Set<String> temp, int count) {

        if (idx == s.length()) {
            total = Math.max(total, count);
            return;
        }

        if ((count + s.length() - idx) <= total) {
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            String str = s.substring(idx, i + 1);
            if (!temp.contains(str)) {
                temp.add(str);
                backtrack(s, i + 1, temp, count + 1);
                temp.remove(str);
            }
        }
    }
}

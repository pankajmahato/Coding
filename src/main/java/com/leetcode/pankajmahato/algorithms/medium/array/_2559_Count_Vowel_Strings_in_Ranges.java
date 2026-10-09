/**********************************************************************************
 *
 * https://leetcode.com/problems/count-vowel-strings-in-ranges/
 *
 * You are given a 0-indexed array of strings words and a 2D array of integers queries.
 *
 * Each query queries[i] = [li, ri] asks us to find the number of strings present at the indices ranging from li to ri (both inclusive) of words that start and end with a vowel.
 *
 * Return an array ans of size queries.length, where ans[i] is the answer to the ith query.
 *
 * Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
 * Output: [2,3,0]
 * Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
 * The answer to the query [0,2] is 2 (strings "aba" and "ece").
 * to query [1,4] is 3 (strings "ece", "aa", "e").
 * to query [1,1] is 0.
 * We return [2,3,0].
 * Example 2:
 *
 * Input: words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
 * Output: [3,2,1]
 * Explanation: Every string satisfies the conditions, so we return [3,2,1].
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 105
 * 1 <= words[i].length <= 40
 * words[i] consists only of lowercase English letters.
 * sum(words[i].length) <= 3 * 105
 * 1 <= queries.length <= 105
 * 0 <= li <= ri < words.length
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _2559_Count_Vowel_Strings_in_Ranges {

    public int[] vowelStrings(String[] words, int[][] queries) {

        int n = words.length;
        int m = queries.length;

        int[] prefixCount = new int[n];
        prefixCount[0] = isValidVowelString(words[0]) ? 1 : 0;
        int[] result = new int[m];

        for (int i = 1; i < n; i++) {
            prefixCount[i] = prefixCount[i - 1] + (isValidVowelString(words[i]) ? 1 : 0);
        }

        for (int i = 0; i < m; i++) {

            int start = queries[i][0];
            int end = queries[i][1];

            result[i] = prefixCount[end] - (start == 0 ? 0 : prefixCount[start - 1]);
        }

        return result;
    }

    private boolean isValidVowelString(String word) {

        char start = word.charAt(0);
        char end = word.charAt(word.length() - 1);

        // Extremely fast compared to Set
        // Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        String vowels = "aeiou";

        if (vowels.indexOf(start) != -1 && vowels.indexOf(end) != -1) {
            return true;
        } else {
            return false;
        }
    }
}

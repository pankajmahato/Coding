/**********************************************************************************
 *
 * https://leetcode.com/problems/longest-common-suffix-queries/
 *
 * You are given two arrays of strings wordsContainer and wordsQuery.
 *
 * For each wordsQuery[i], you need to find a string from wordsContainer that has the longest common suffix with wordsQuery[i]. If there are two or more strings in wordsContainer that share the longest common suffix, find the string that is the smallest in length. If there are two or more such strings that have the same smallest length, find the one that occurred earlier in wordsContainer.
 *
 * Return an array of integers ans, where ans[i] is the index of the string in wordsContainer that has the longest common suffix with wordsQuery[i].
 *
 *
 *
 * Example 1:
 *
 * Input: wordsContainer = ["abcd","bcd","xbcd"], wordsQuery = ["cd","bcd","xyz"]
 *
 * Output: [1,1,1]
 *
 * Explanation:
 *
 * Let's look at each wordsQuery[i] separately:
 *
 * For wordsQuery[0] = "cd", strings from wordsContainer that share the longest common suffix "cd" are at indices 0, 1, and 2. Among these, the answer is the string at index 1 because it has the shortest length of 3.
 * For wordsQuery[1] = "bcd", strings from wordsContainer that share the longest common suffix "bcd" are at indices 0, 1, and 2. Among these, the answer is the string at index 1 because it has the shortest length of 3.
 * For wordsQuery[2] = "xyz", there is no string from wordsContainer that shares a common suffix. Hence the longest common suffix is "", that is shared with strings at index 0, 1, and 2. Among these, the answer is the string at index 1 because it has the shortest length of 3.
 * Example 2:
 *
 * Input: wordsContainer = ["abcdefgh","poiuygh","ghghgh"], wordsQuery = ["gh","acbfgh","acbfegh"]
 *
 * Output: [2,0,2]
 *
 * Explanation:
 *
 * Let's look at each wordsQuery[i] separately:
 *
 * For wordsQuery[0] = "gh", strings from wordsContainer that share the longest common suffix "gh" are at indices 0, 1, and 2. Among these, the answer is the string at index 2 because it has the shortest length of 6.
 * For wordsQuery[1] = "acbfgh", only the string at index 0 shares the longest common suffix "fgh". Hence it is the answer, even though the string at index 2 is shorter.
 * For wordsQuery[2] = "acbfegh", strings from wordsContainer that share the longest common suffix "gh" are at indices 0, 1, and 2. Among these, the answer is the string at index 2 because it has the shortest length of 6.
 *
 *
 * Constraints:
 *
 * 1 <= wordsContainer.length, wordsQuery.length <= 104
 * 1 <= wordsContainer[i].length <= 5 * 103
 * 1 <= wordsQuery[i].length <= 5 * 103
 * wordsContainer[i] consists only of lowercase English letters.
 * wordsQuery[i] consists only of lowercase English letters.
 * Sum of wordsContainer[i].length is at most 5 * 105.
 * Sum of wordsQuery[i].length is at most 5 * 105.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.trie;

public class _3093_Longest_Common_Suffix_Queries {

    int N = 26;

    class TrieNode {
        int smallestIndex = -1;
        TrieNode[] children = new TrieNode[N];
    }

    private TrieNode getNode(int idx) {
        TrieNode temp = new TrieNode();
        temp.smallestIndex = idx;

        for (int i = 0; i < 26; i++) {
            temp.children[i] = null;
        }
        return temp;
    }

    private void insertTrieNode(TrieNode root, String[] wordsContainer, int idx) {

        for (int i = wordsContainer[idx].length() - 1; i >= 0; i--) {
            char ch = wordsContainer[idx].charAt(i);
            int cIdx = ch - 'a';
            if (root.children[cIdx] == null) {
                root.children[cIdx] = getNode(idx);
            }

            root = root.children[cIdx];
            if (wordsContainer[root.smallestIndex].length() > wordsContainer[idx].length()) {
                root.smallestIndex = idx;
            }
        }
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        TrieNode root = getNode(0);
        // Insert all the words
        for (int i = 0; i < wordsContainer.length; i++) {
            if (wordsContainer[root.smallestIndex].length() > wordsContainer[i].length()) {
                root.smallestIndex = i;
            }
            insertTrieNode(root, wordsContainer, i);
        }

        int n = wordsQuery.length;

        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            result[i] = findLongestCommonSuffix(root, wordsQuery[i]);
        }

        return result;
    }

    private int findLongestCommonSuffix(TrieNode root, String word) {

        int result = root.smallestIndex;
        int n = word.length();
        for (int i = n - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            root = root.children[idx];
            if (root == null) {
                break;
            }
            result = root.smallestIndex;
        }

        return result;
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/word-search-ii/
 *
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * Example 2:
 *
 *
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.trie;

import java.util.ArrayList;
import java.util.List;

public class _212_Word_Search_II {

    int N = 26;
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    class TrieNode {
        boolean end;
        String word;
        TrieNode[] children = new TrieNode[N];
    }

    private TrieNode getNode() {

        TrieNode node = new TrieNode();
        node.end = false;
        node.word = "";
        for (int i = 0; i < N; i++) {
            node.children[i] = null;
        }

        return node;
    }

    private void insertWord(TrieNode head, String word) {

        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            int idx = c - 'a';
            if (head.children[idx] == null) {
                head.children[idx] = getNode();
            }

            head = head.children[idx];
        }

        head.end = true;
        head.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {

        int m = board.length;
        int n = board[0].length;

        // Root node
        TrieNode root = getNode();

        // Insert all the words
        for (int i = 0; i < words.length; i++) {
            insertWord(root, words[i]);
        }

        List<String> result = new ArrayList<>();
        // Check for all possible words starting with chars in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                solve(board, m, n, i, j, root, result);
            }
        }

        return result;
    }

    private void solve(char[][] board, int m, int n, int i, int j, TrieNode root, List<String> result) {

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (board[i][j] == '$' || root.children[board[i][j] - 'a'] == null) {
            return;
        }

        root = root.children[board[i][j] - 'a'];

        if (root.end == true) {
            result.add(root.word);
            root.end = false;
        }

        char temp = board[i][j];
        board[i][j] = '$';
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            solve(board, m, n, x, y, root, result);
        }

        board[i][j] = temp;
    }
}

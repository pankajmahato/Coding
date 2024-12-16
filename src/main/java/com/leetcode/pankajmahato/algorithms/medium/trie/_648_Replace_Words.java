/**********************************************************************************
 *
 * https://leetcode.com/problems/replace-words/
 *
 * In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word derivative. For example, when the root "help" is followed by the word "ful", we can form a derivative "helpful".
 *
 * Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root, replace it with the root that has the shortest length.
 *
 * Return the sentence after the replacement.
 *
 *
 *
 * Example 1:
 *
 * Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * Example 2:
 *
 * Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * Output: "a a b c"
 *
 *
 * Constraints:
 *
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] consists of only lower-case letters.
 * 1 <= sentence.length <= 106
 * sentence consists of only lower-case letters and spaces.
 * The number of words in sentence is in the range [1, 1000]
 * The length of each word in sentence is in the range [1, 1000]
 * Every two consecutive words in sentence will be separated by exactly one space.
 * sentence does not have leading or trailing spaces.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.trie;

import java.util.List;

public class _648_Replace_Words {

//    public String replaceWords(List<String> dictionary, String sentence) {
//
//        Set<String> set = new HashSet(dictionary);
//
//        StringBuilder sb = new StringBuilder();
//        for (String word : sentence.split(" ")) {
//            sb.append(findRoot(word, set)).append(" ");
//        }
//
//        return sb.toString().trim();
//    }
//
//    private String findRoot(String word, Set<String> set) {
//
//        for (int i = 0; i < word.length(); i++) {
//
//            String root = word.substring(0, i + 1);
//            if (set.contains(root)) {
//                return root;
//            }
//        }
//
//        return word;
//    }

    int N = 26;

    class TrieNode {
        boolean end;
        String word = "";
        TrieNode[] children = new TrieNode[N];
    }

    private void insertTrieNode(TrieNode root, String word) {

        int n = word.length();
        for (int i = 0; i < n; i++) {
            int idx = word.charAt(i) - 'a';
            if (root.children[idx] == null) {
                root.children[idx] = new TrieNode();
            }

            root = root.children[idx];
        }

        root.end = true;
        root.word = word;

    }

    public String replaceWords(List<String> dictionary, String sentence) {

        TrieNode root = new TrieNode();

        for (String dict : dictionary) {
            insertTrieNode(root, dict);
        }

        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split(" ")) {
            sb.append(searchTrie(root, word)).append(" ");
        }

        return sb.toString().trim();
    }

    private String searchTrie(TrieNode root, String word) {

        String result = word;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int idx = word.charAt(i) - 'a';
            if (root.children[idx] == null) {
                break;
            }

            root = root.children[idx];
            if (root.end == true) {
                result = root.word;
                break;
            }
        }

        return result;

    }
}

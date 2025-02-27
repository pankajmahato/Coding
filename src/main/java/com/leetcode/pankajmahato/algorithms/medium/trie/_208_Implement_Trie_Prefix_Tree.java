/**********************************************************************************
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 *
 * Example 1:
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.trie;

public class _208_Implement_Trie_Prefix_Tree {

    // Array is 2x faster than HashMap
    class TrieNode {
        boolean end;
        // Map<Character, TrieNode> children = new HashMap<>();
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root;

    public _208_Implement_Trie_Prefix_Tree() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode head = root;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);
            // if (!head.children.containsKey(ch)) {
            // head.children.put(ch, new TrieNode());
            // }

            // head = head.children.get(ch);
            if (head.children[ch - 'a'] == null) {
                head.children[ch - 'a'] = new TrieNode();
            }

            head = head.children[ch - 'a'];
        }

        head.end = true;
    }

    public boolean search(String word) {

        TrieNode head = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // if (!head.children.containsKey(ch)) {
            // return false;
            // }
            // head = head.children.get(ch);
            if (head.children[ch - 'a'] == null) {
                return false;
            }

            head = head.children[ch - 'a'];
        }

        return head.end;
    }

    public boolean startsWith(String prefix) {

        TrieNode head = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            // if (!head.children.containsKey(ch)) {
            // return false;
            // }
            // head = head.children.get(ch);
            if (head.children[ch - 'a'] == null) {
                return false;
            }

            head = head.children[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

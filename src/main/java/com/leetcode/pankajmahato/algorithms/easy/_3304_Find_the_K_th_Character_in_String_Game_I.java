/**********************************************************************************
 *
 * https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/
 *
 * Alice and Bob are playing a game. Initially, Alice has a string word = "a".
 *
 * You are given a positive integer k.
 *
 * Now Bob will ask Alice to perform the following operation forever:
 *
 * Generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word.
 * For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".
 *
 * Return the value of the kth character in word, after enough operations have been done for word to have at least k characters.
 *
 * Note that the character 'z' can be changed to 'a' in the operation.
 *
 *
 *
 * Example 1:
 *
 * Input: k = 5
 *
 * Output: "b"
 *
 * Explanation:
 *
 * Initially, word = "a". We need to do the operation three times:
 *
 * Generated string is "b", word becomes "ab".
 * Generated string is "bc", word becomes "abbc".
 * Generated string is "bccd", word becomes "abbcbccd".
 * Example 2:
 *
 * Input: k = 10
 *
 * Output: "c"
 *
 *
 *
 * Constraints:
 *
 * 1 <= k <= 500
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy;

public class _3304_Find_the_K_th_Character_in_String_Game_I {
    public char kthCharacter(int k) {

        if (k == 1) {
            return 'a';
        }

        int len = 1;
        while (len < k) {
            len = len * 2;
        }
        char ch = kthCharacter(k - len / 2);
        return ch == 'z' ? 'a' : (char) (ch + 1);
    }

    public static void main(String[] args) {
        System.out.println(new _3304_Find_the_K_th_Character_in_String_Game_I().kthCharacter(10));
    }
}

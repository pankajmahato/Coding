/**********************************************************************************
 *
 * https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/
 *
 * You are given a string word, and an integer numFriends.
 *
 * Alice is organizing a game for her numFriends friends. There are multiple rounds in the game, where in each round:
 *
 * word is split into numFriends non-empty strings, such that no previous round has had the exact same split.
 * All the split words are put into a box.
 * Find the lexicographically largest string from the box after all the rounds are finished.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "dbca", numFriends = 2
 *
 * Output: "dbc"
 *
 * Explanation: 
 *
 * All possible splits are:
 *
 * "d" and "bca".
 * "db" and "ca".
 * "dbc" and "a".
 * Example 2:
 *
 * Input: word = "gggg", numFriends = 4
 *
 * Output: "g"
 *
 * Explanation: 
 *
 * The only possible split is: "g", "g", "g", and "g".
 *
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 5 * 103
 * word consists only of lowercase English letters.
 * 1 <= numFriends <= word.length
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.string;

public class _3403_Find_the_Lexicographically_Largest_String_From_the_Box_I {

    // public String answerString(String word, int numFriends) {

    //     if (numFriends == 1) {
    //         return word;
    //     }
    //     int n = word.length();

    //     char maxChar = ' ';

    //     for (int i = 0; i < n; i++) {

    //         char ch = word.charAt(i);
    //         if (ch >= maxChar) {
    //             maxChar = ch;
    //         }
    //     }

    //     List<Integer> maxCharIdxList = new ArrayList<>();
    //     for (int i = 0; i < n; i++) {

    //         if (maxChar == word.charAt(i)) {
    //             maxCharIdxList.add(i);
    //         }
    //     }

    //     // Assign 1 letter to everyone except 1 friend. The last friend will have the longest word
    //     int lenOfMaxWord = n - (numFriends - 1);

    //     String result = "";
    //     for (int i : maxCharIdxList) {
    //         StringBuilder sb = new StringBuilder();

    //         int len = 1;
    //         while (i < n && len <= lenOfMaxWord) {
    //             sb.append(word.charAt(i));
    //             i++;
    //             len++;
    //         }
    //         String temp = sb.toString();
    //         if (temp.compareTo(result) >= 1) {
    //             result = temp;
    //         }
    //     }

    //     return result;
    // }

    public String answerString(String word, int numFriends) {

        if (numFriends == 1) {
            return word;
        }
        int n = word.length();

        // Assign 1 letter to everyone except 1 friend. The last friend will have the longest word
        int lenOfMaxWord = n - (numFriends - 1);

        String result = "";
        for (int i = 0; i < n; i++) {

            int maxIdx = Math.min(i + lenOfMaxWord, n);
            String temp = word.substring(i, maxIdx);
            if (temp.compareTo(result) >= 1) {
                result = temp;
            }
        }

        return result;
    }
}

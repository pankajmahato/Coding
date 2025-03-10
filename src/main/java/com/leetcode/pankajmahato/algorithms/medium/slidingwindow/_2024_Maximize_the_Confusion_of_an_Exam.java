/**********************************************************************************
 *
 * https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
 *
 * A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).
 *
 * You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you are given an integer k, the maximum number of times you may perform the following operation:
 *
 * Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
 * Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.
 *
 *
 *
 * Example 1:
 *
 * Input: answerKey = "TTFF", k = 2
 * Output: 4
 * Explanation: We can replace both the 'F's with 'T's to make answerKey = "TTTT".
 * There are four consecutive 'T's.
 * Example 2:
 *
 * Input: answerKey = "TFFT", k = 1
 * Output: 3
 * Explanation: We can replace the first 'T' with an 'F' to make answerKey = "FFFT".
 * Alternatively, we can replace the second 'T' with an 'F' to make answerKey = "TFFF".
 * In both cases, there are three consecutive 'F's.
 * Example 3:
 *
 * Input: answerKey = "TTFTTFTT", k = 1
 * Output: 5
 * Explanation: We can replace the first 'F' to make answerKey = "TTTTTFTT"
 * Alternatively, we can replace the second 'F' to make answerKey = "TTFTTTTT". 
 * In both cases, there are five consecutive 'T's.
 *
 *
 * Constraints:
 *
 * n == answerKey.length
 * 1 <= n <= 5 * 104
 * answerKey[i] is either 'T' or 'F'
 * 1 <= k <= n
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class _2024_Maximize_the_Confusion_of_an_Exam {

//    public int maxConsecutiveAnswers(String answerKey, int k) {
//
//        // 2 pass sliding window
//        int result = 0;
//        // Case 1: Flip 'F' to 'T'
//        result = Math.max(result, flip(answerKey, k, 'F'));
//
//        // Case 1: Flip 'T' to 'F'
//        result = Math.max(result, flip(answerKey, k, 'T'));
//
//        return result;
//    }
//
//    private int flip(String answerKey, int k, char ch) {
//
//        int n = answerKey.length();
//        int count = 0;
//        int i = 0;
//        int j = 0;
//        int result = 0;
//
//        while (j < n) {
//
//            if (answerKey.charAt(j) == ch) {
//                count++;
//
//                while (count > k) {
//
//                    if (answerKey.charAt(i) == ch) {
//                        count--;
//                    }
//                    i++;
//                }
//            }
//            result = Math.max(result, j - i + 1);
//            j++;
//        }
//
//        return result;
//    }

    public int maxConsecutiveAnswers(String answerKey, int k) {

        // 1 pass sliding window
        int n = answerKey.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put('T', 0);
        map.put('F', 0);

        int result = 0;
        int i = 0;
        int j = 0;

        while (j < n) {

            map.put(answerKey.charAt(j), map.get(answerKey.charAt(j)) + 1);

            while (Math.min(map.get('F'), map.get('T')) > k) {
                map.put(answerKey.charAt(i), map.get(answerKey.charAt(i)) - 1);
                i++;
            }

            result = Math.max(result, j - i + 1);
            j++;
        }

        return result;
    }

}

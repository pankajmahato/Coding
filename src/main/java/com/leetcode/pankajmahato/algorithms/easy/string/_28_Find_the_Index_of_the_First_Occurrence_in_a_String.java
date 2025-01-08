/**********************************************************************************
 *
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.string;

public class _28_Find_the_Index_of_the_First_Occurrence_in_a_String {

//    public int strStr(String haystack, String needle) {
//
//        int m = haystack.length();
//        int n = needle.length();
//
//        for (int i = 0; i <= m - n; i++) {
//            int j = 0;
//            for (; j < n; j++) {
//                if (haystack.charAt(i + j) != needle.charAt(j)) {
//                    break;
//                }
//            }
//
//            if (j == n) {
//                return i;
//            }
//        }
//
//        return -1;
//    }

    public int strStr(String haystack, String needle) {

        // KMP
        int m = haystack.length();
        int n = needle.length();

        // LPS[i] = Length of longest equal prefix and suffix ending at i-th index
        int[] LPS = new int[n];
        computeLPS(needle, n, LPS);

        int i = 0;
        int j = 0;

        while (i < m) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == n) {
                return i - j;
            } else if (i < m && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = LPS[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    private void computeLPS(String needle, int n, int[] LPS) {

        // Length of the previous longest prefix suffix
        int len = 0;

        LPS[0] = 0;

        int i = 1;
        while (i < n) {

            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                LPS[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = LPS[len - 1];
                } else {
                    LPS[i] = 0;
                    i++;
                }
            }
        }
    }
}

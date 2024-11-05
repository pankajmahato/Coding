/**********************************************************************************
 *
 * https://leetcode.com/problems/valid-anagram/
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.string;

public class _242_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] = arr[s.charAt(i) - 'a'] + 1;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a'] = arr[t.charAt(i) - 'a'] - 1;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

//    public boolean isAnagram(String s, String t) {
//        HashMap<Character, Integer> smap = new HashMap<>();
//        int sl = s.length();
//        int tl = t.length();
//        if (sl != tl) {
//            return false;
//        }
//        for (int i = 0; i < sl; i++) {
//            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
//            smap.put(t.charAt(i), smap.getOrDefault(t.charAt(i), 0) - 1);
//        }
//        for (char c : smap.keySet()) {
//            if (smap.get(c) != 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }
}

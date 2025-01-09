/**********************************************************************************
 *
 * https://leetcode.com/problems/is-subsequence/
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 *
 *
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _392_Is_Subsequence {

//    public boolean isSubsequence(String s, String t) {
//
//        int n1 = s.length();
//        int n2 = t.length();
//        int i = 0;
//        int j = 0;
//
//        while (i < n1 && j < n2) {
//            if (s.charAt(i) == t.charAt(j)) {
//                i++;
//                j++;
//            } else {
//                j++;
//            }
//        }
//
//        return i == n1;
//    }

    public boolean isSubsequence(String s, String t) {

        // Follow up
        int n1 = s.length();
        int n2 = t.length();

        Map<Character, List<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < n2; i++) {
            char ch = t.charAt(i);
            indexMap.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }

        int prevIdx = -1;

        for (int i = 0; i < n1; i++) {

            char ch = s.charAt(i);

            if (!indexMap.containsKey(ch)) {
                return false;
            }

            List<Integer> indices = indexMap.get(ch);

            int nextIdx = binarySearchUpperBound(indices, prevIdx);

            if (nextIdx == indices.size()) {
                return false;
            }

            prevIdx = indices.get(nextIdx);
        }

        return true;
    }

    // The lower bound is the smallest index, ind, where arr[ind] >= x. But if any
    // such index is not found, returns n i.e. size of the given array.
    private int binarySearchLowerBound(List<Integer> nums, int target) {
        int l = 0;
        int r = nums.size() - 1;
        int ans = nums.size();
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums.get(mid) >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    // The upper bound is the smallest index, ind, where arr[ind] > x. But if any
    // such index is not found, returns n i.e. size of the given array.
    private int binarySearchUpperBound(List<Integer> nums, int target) {
        int l = 0;
        int r = nums.size() - 1;
        int ans = nums.size();
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums.get(mid) > target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}

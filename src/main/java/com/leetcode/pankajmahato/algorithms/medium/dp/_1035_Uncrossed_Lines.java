/**********************************************************************************
 *
 * https://leetcode.com/problems/uncrossed-lines/
 *
 * You are given two integer arrays nums1 and nums2. We write the integers of nums1 and nums2 (in the order they are given) on two separate horizontal lines.
 *
 * We may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:
 *
 * nums1[i] == nums2[j], and
 * the line we draw does not intersect any other connecting (non-horizontal) line.
 * Note that a connecting line cannot intersect even at the endpoints (i.e., each number can only belong to one connecting line).
 *
 * Return the maximum number of connecting lines we can draw in this way.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums1 = [1,4,2], nums2 = [1,2,4]
 * Output: 2
 * Explanation: We can draw 2 uncrossed lines as in the diagram.
 * We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to nums2[2] = 4 will intersect the line from nums1[2]=2 to nums2[1]=2.
 * Example 2:
 *
 * Input: nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
 * Output: 3
 * Example 3:
 *
 * Input: nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 500
 * 1 <= nums1[i], nums2[j] <= 2000
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _1035_Uncrossed_Lines {

    // public int maxUncrossedLines(int[] nums1, int[] nums2) {

    //     // DP Top Down
    //     int m = nums1.length;
    //     int n = nums2.length;

    //     // dp[i][j] = Result from ith index in nums1 and jth index in nums2
    //     int[][] dp = new int[m][n];
    //     for (int[] arr : dp) {
    //         Arrays.fill(arr, -1);
    //     }

    //     return solve(0, 0, m, n, nums1, nums2, dp);
    // }

    // private int solve(int i, int j, int m, int n, int[] nums1, int[] nums2, int[][] dp) {

    //     if (i == m || j == n) {
    //         return 0;
    //     }

    //     if (dp[i][j] != -1) {
    //         return dp[i][j];
    //     }

    //     if (nums1[i] != nums2[j]) {
    //         int skipI = solve(i + 1, j, m, n, nums1, nums2, dp);
    //         int skipJ = solve(i, j + 1, m, n, nums1, nums2, dp);

    //         return dp[i][j] = Math.max(skipI, skipJ);
    //     }

    //     return dp[i][j] = 1 + solve(i + 1, j + 1, m, n, nums1, nums2, dp);
    // }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        // DP Bottom Up
        int m = nums1.length;
        int n = nums2.length;

        // dp[i][j] = Result from ith index in nums1 and jth index in nums2
        // Size is (m + 1) x (n + 1) to account for boundary conditions (i == m or j == n)
        int[][] dp = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (nums1[i] != nums2[j]) {
                    int skipI = dp[i + 1][j];
                    int skipJ = dp[i][j + 1];

                    dp[i][j] = Math.max(skipI, skipJ);
                } else {

                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
 *
 * Given an array of integers arr of even length n and an integer k.
 *
 * We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
 *
 * Return true If you can find a way to do that or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
 * Output: true
 * Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).
 * Example 2:
 *
 * Input: arr = [1,2,3,4,5,6], k = 7
 * Output: true
 * Explanation: Pairs are (1,6),(2,5) and(3,4).
 * Example 3:
 *
 * Input: arr = [1,2,3,4,5,6], k = 10
 * Output: false
 * Explanation: You can try all possible pairs to see that there is no way to divide arr into 3 pairs each with sum divisible by 10.
 *
 *
 * Constraints:
 *
 * arr.length == n
 * 1 <= n <= 105
 * n is even.
 * -109 <= arr[i] <= 109
 * 1 <= k <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.hashmap;

public class _1497_Check_If_Array_Pairs_Are_Divisible_by_k {

    public boolean canArrange(int[] arr, int k) {

        // index = remainder; Value = count
        int[] map = new int[k];

        for (int i = 0; i < arr.length; i++) {
            // Handling negative numbers mod
            int rem = arr[i] % k;
            if (rem < 0) {
                rem = rem + k;
            }
            map[rem]++;
        }

        if (map[0] % 2 != 0) {
            return false;
        }

        for (int i = 1; i <= k / 2; i++) {
            if (map[i] != map[k - i]) {
                return false;
            }
        }

        return true;
    }
}

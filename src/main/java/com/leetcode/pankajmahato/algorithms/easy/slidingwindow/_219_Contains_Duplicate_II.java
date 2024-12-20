/**********************************************************************************
 *
 * https://leetcode.com/problems/contains-duplicate-ii/
 *
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.slidingwindow;


import java.util.HashSet;
import java.util.Set;

public class _219_Contains_Duplicate_II {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int n = nums.length;

        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while (j < n) {

            if (j - i > k) {
                set.remove(nums[i]);
                i++;
            }

            if (set.contains(nums[j])) {
                return true;
            }

            set.add(nums[j]);
            j++;
        }

        return false;
    }
}

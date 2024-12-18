/**********************************************************************************
 *
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 *
 * You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
 *
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 *
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 105
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1 and nums2 both are sorted in non-decreasing order.
 * 1 <= k <= 104
 * k <= nums1.length * nums2.length
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.heap;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _373_Find_K_Pairs_with_Smallest_Sums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int num : nums1) {
            queue.add(new int[]{num + nums2[0], 0});
        }

        List<List<Integer>> result = new ArrayList<>();

        while (k > 0 && !queue.isEmpty()) {

            int[] pair = queue.remove();
            int sum = pair[0];
            int index = pair[1];

            List<Integer> currPair = new ArrayList<>();
            // Number from nums1
            currPair.add(sum - nums2[index]);
            // Number from nums2
            currPair.add(nums2[index]);

            result.add(currPair);

            if (index < nums2.length - 1) {
                queue.add(new int[]{sum - nums2[index] + nums2[index + 1], index + 1});
            }

            k--;
        }

        return result;
    }
}

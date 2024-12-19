/**********************************************************************************
 *
 * https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
 *
 * You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.
 *
 * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
 * Output: [20,24]
 * Explanation: 
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 * Example 2:
 *
 * Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
 * Output: [1,1]
 *
 *
 * Constraints:
 *
 * nums.length == k
 * 1 <= k <= 3500
 * 1 <= nums[i].length <= 50
 * -105 <= nums[i][j] <= 105
 * nums[i] is sorted in non-decreasing order.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.heap;


import java.util.List;
import java.util.PriorityQueue;

public class _632_Smallest_Range_Covering_Elements_from_K_Lists {

    public int[] smallestRange(List<List<Integer>> nums) {

        int k = nums.size();

        // Stores the indices of k lists; k-th list is stored on i-th index
        int[] indices = new int[k];

        // Store the indices(int[] = {value, List's index, value's index}) but sort in
        // ascending based on values
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // // Store the indices(int[] = {value, List's index, value's index}) but sort
        // in descending based on values
        // PriorityQueue<int[]> maxHeap = new
        // PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));

        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            minHeap.add(new int[]{nums.get(i).get(0), i, 0});
            maxElement = Math.max(maxElement, nums.get(i).get(0));
        }

        int[] result = new int[]{-(int) 1e6, (int) 1e6};

        while (!minHeap.isEmpty()) {
            int[] val = minHeap.remove();
            int minElement = val[0];
            int minElementListIndex = val[1];
            int minElementValueIndex = val[2];

            if (maxElement - minElement < result[1] - result[0]) {
                result[0] = minElement;
                result[1] = maxElement;
            }

            if (minElementValueIndex + 1 < nums.get(minElementListIndex).size()) {
                int newElement = nums.get(minElementListIndex).get(minElementValueIndex + 1);
                minHeap.add(new int[]{newElement, minElementListIndex, minElementValueIndex + 1});
                maxElement = Math.max(maxElement, newElement);
            } else {
                break;
            }
        }

        return result;
    }
}

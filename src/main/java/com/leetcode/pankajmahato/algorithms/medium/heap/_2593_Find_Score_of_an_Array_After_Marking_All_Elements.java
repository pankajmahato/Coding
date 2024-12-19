/**********************************************************************************
 *
 * https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/
 *
 * You are given an array nums consisting of positive integers.
 *
 * Starting with score = 0, apply the following algorithm:
 *
 * Choose the smallest integer of the array that is not marked. If there is a tie, choose the one with the smallest index.
 * Add the value of the chosen integer to score.
 * Mark the chosen element and its two adjacent elements if they exist.
 * Repeat until all the array elements are marked.
 * Return the score you get after applying the above algorithm.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,1,3,4,5,2]
 * Output: 7
 * Explanation: We mark the elements as follows:
 * - 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,1,3,4,5,2].
 * - 2 is the smallest unmarked element, so we mark it and its left adjacent element: [2,1,3,4,5,2].
 * - 4 is the only remaining unmarked element, so we mark it: [2,1,3,4,5,2].
 * Our score is 1 + 2 + 4 = 7.
 * Example 2:
 *
 * Input: nums = [2,3,5,1,3,2]
 * Output: 5
 * Explanation: We mark the elements as follows:
 * - 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,3,5,1,3,2].
 * - 2 is the smallest unmarked element, since there are two of them, we choose the left-most one, so we mark the one at index 0 and its right adjacent element: [2,3,5,1,3,2].
 * - 2 is the only remaining unmarked element, so we mark it: [2,3,5,1,3,2].
 * Our score is 1 + 2 + 2 = 5.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.heap;


import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class _2593_Find_Score_of_an_Array_After_Marking_All_Elements {

    class Pair {
        int num;
        int idx;

        Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public long findScore(int[] nums) {

        int n = nums.length;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            int val = Integer.compare(a.num, b.num);
            if (val != 0) {
                return val;
            }

            return Integer.compare(a.idx, b.idx);
        });

        for (int i = 0; i < n; i++) {
            minHeap.add(new Pair(nums[i], i));
        }

        long score = 0;
        Set<Integer> marked = new HashSet<>();

        while (!minHeap.isEmpty()) {

            Pair val = minHeap.remove();
            if (!marked.contains(val.idx)) {
                if (val.idx > 0) {
                    marked.add(val.idx - 1);
                }
                if (val.idx < n - 1) {
                    marked.add(val.idx + 1);
                }
                score += (long) val.num;
            }
        }

        return score;
    }
}

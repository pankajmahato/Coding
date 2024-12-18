/**********************************************************************************
 *
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.heap;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _347_Top_K_Frequent_Elements {

//    public int[] topKFrequent(int[] nums, int k) {
//
//        // Priority Queue
//        int n = nums.length;
//        Map<Integer, Integer> freqMap = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
//        }
//
//        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) ->
//                Integer.compare(a[1], b[1]));
//
//        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
//            queue.add(new int[]{entry.getKey(), entry.getValue()});
//            if (queue.size() > k) {
//                queue.remove();
//            }
//        }
//
//        int[] result = new int[k];
//        int i = k - 1;
//        while (i >= 0) {
//            result[i--] = queue.remove()[0];
//        }
//
//        return result;
//    }

    public int[] topKFrequent(int[] nums, int k) {

        // Bucket Sort; Faster than Priority Queue
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        // Max size = n + 1 (0-based index)
        List<Integer>[] freqList = new List[n + 1];

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            int num = entry.getKey();

            if (freqList[freq] == null) {
                freqList[freq] = new ArrayList<>();
            }
            freqList[freq].add(num);
        }

        int[] result = new int[k];
        int i = k - 1;
        int idx = freqList.length - 1;
        while (idx >= 0 && i >= 0) {
            if (freqList[idx] != null) {
                for (int num : freqList[idx]) {
                    result[i--] = num;
                }
            }
            idx--;
        }

        return result;
    }
}

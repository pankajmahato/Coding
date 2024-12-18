/**********************************************************************************
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.heap;


import java.util.PriorityQueue;

public class _215_Kth_Largest_Element_in_an_Array {

//    public int findKthLargest(int[] nums, int k) {
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//
//        for (int num : nums) {
//            queue.add(num);
//            if (queue.size() > k) {
//                queue.remove();
//            }
//        }
//
//        return queue.peek();
//    }

    public int findKthLargest(int[] nums, int k) {

        // Quick Select
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int pivotIdx = 0;
        while (true) {

            pivotIdx = partition(nums, l, r);

            if (pivotIdx == k - 1) {
                break;
            } else if (pivotIdx > k - 1) {
                r = pivotIdx - 1;
            } else {
                l = pivotIdx + 1;
            }
        }

        return nums[pivotIdx];
    }

    private int partition(int[] nums, int l, int r) {

        int pivotVal = nums[l];
        int i = l + 1;
        int j = r;

        while (i <= j) {

            if (nums[i] < pivotVal && nums[j] > pivotVal) {
                swap(nums, i, j);
                i++;
                j--;
            }

            if (nums[i] >= pivotVal) {
                i++;
            }

            if (nums[j] <= pivotVal) {
                j--;
            }
        }

        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

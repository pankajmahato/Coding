/**********************************************************************************
 *
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 *
 *
 * Example 1:
 *
 * Input
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * Output
 * [null, null, null, 1.5, null, 2.0]
 *
 * Explanation
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 *
 *
 * Constraints:
 *
 * -105 <= num <= 105
 * There will be at least one element in the data structure before calling findMedian.
 * At most 5 * 104 calls will be made to addNum and findMedian.
 *
 *
 * Follow up:
 *
 * If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 * If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.heap;


import java.util.Collections;
import java.util.PriorityQueue;

public class _295_Find_Median_from_Data_Stream {


    PriorityQueue<Integer> leftMaxHeap;
    PriorityQueue<Integer> rightMinHeap;

    public _295_Find_Median_from_Data_Stream() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        if (leftMaxHeap.isEmpty() || leftMaxHeap.peek() > num) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }

        if (leftMaxHeap.size() > rightMinHeap.size() + 1) {
            rightMinHeap.add(leftMaxHeap.remove());
        } else if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.add(rightMinHeap.remove());
        }
    }

    public double findMedian() {

        if (leftMaxHeap.size() > rightMinHeap.size()) {
            return leftMaxHeap.peek();
        } else {
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

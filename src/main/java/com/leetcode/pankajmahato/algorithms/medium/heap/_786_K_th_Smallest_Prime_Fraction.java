/**********************************************************************************
 *
 * https://leetcode.com/problems/k-th-smallest-prime-fraction/
 *
 * You are given a sorted integer array arr containing 1 and prime numbers, where all the integers of arr are unique. You are also given an integer k.
 *
 * For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].
 *
 * Return the kth smallest fraction considered. Return your answer as an array of integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j].
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,5], k = 3
 * Output: [2,5]
 * Explanation: The fractions to be considered in sorted order are:
 * 1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
 * The third fraction is 2/5.
 * Example 2:
 *
 * Input: arr = [1,7], k = 1
 * Output: [1,7]
 *
 *
 * Constraints:
 *
 * 2 <= arr.length <= 1000
 * 1 <= arr[i] <= 3 * 104
 * arr[0] == 1
 * arr[i] is a prime number for i > 0.
 * All the numbers of arr are unique and sorted in strictly increasing order.
 * 1 <= k <= arr.length * (arr.length - 1) / 2
 *
 *
 * Follow up: Can you solve the problem with better than O(n2) complexity?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.heap;


import java.util.PriorityQueue;

public class _786_K_th_Smallest_Prime_Fraction {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        // double[] = {fraction, arr[i], arr[j] }
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(a[0], b[0]));

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            queue.add(new double[]{(double) arr[i] / arr[n - 1], i, n - 1});
        }

        int smallest = 1;
        while (smallest < k) {
            double[] val = queue.remove();
            int i = (int) val[1];
            int j = (int) val[2] - 1;

            queue.add(new double[]{(double) arr[i] / arr[j], i, j});
            smallest++;
        }

        double[] result = queue.remove();
        int i = (int) result[1];
        int j = (int) result[2];

        return new int[]{arr[i], arr[j]};
    }
}

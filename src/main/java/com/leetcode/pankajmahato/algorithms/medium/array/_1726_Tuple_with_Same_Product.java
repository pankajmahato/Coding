/**********************************************************************************
 *
 * https://leetcode.com/problems/tuple-with-same-product/
 *
 * Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,4,6]
 * Output: 8
 * Explanation: There are 8 valid tuples:
 * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
 * (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
 * Example 2:
 *
 * Input: nums = [1,2,4,5,10]
 * Output: 16
 * Explanation: There are 16 valid tuples:
 * (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
 * (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
 * (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
 * (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 104
 * All elements in nums are distinct.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.HashMap;
import java.util.Map;

public class _1726_Tuple_with_Same_Product {

    public int tupleSameProduct(int[] nums) {

        // Observation
        // There are 8 ways(permutation) for a given unique Tuple
        // A tuple (a,b,c,d)  = a * b == c * d
        // This means that in the original array there are 2 equal products ((a * b) or (c * d)) having 1 tuple
        // So number of tuples is taking combination of 2 from n equal products -> nCr
        // nCr = n! / (r! * (n-r)!)
        // nC2 = n! / (2! * (n-2)!)
        // nC2 = n * (n-1) / 2!

        int n = nums.length;

        // Product -> Freq
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prod = nums[i] * nums[j];
                freqMap.put(prod, freqMap.getOrDefault(prod, 0) + 1);
            }
        }

        int result = 0;

        for (int N : freqMap.values()) {

            if (N >= 2) {

                // nC2
                result = result + N * (N - 1) / 2;
            }
        }

        return result * 8;
    }
}

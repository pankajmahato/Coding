/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-time-to-repair-cars/
 *
 * You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic. A mechanic with a rank r can repair n cars in r * n2 minutes.
 *
 * You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.
 *
 * Return the minimum time taken to repair all the cars.
 *
 * Note: All the mechanics can repair the cars simultaneously.
 *
 *
 *
 * Example 1:
 *
 * Input: ranks = [4,2,3,1], cars = 10
 * Output: 16
 * Explanation: 
 * - The first mechanic will repair two cars. The time required is 4 * 2 * 2 = 16 minutes.
 * - The second mechanic will repair two cars. The time required is 2 * 2 * 2 = 8 minutes.
 * - The third mechanic will repair two cars. The time required is 3 * 2 * 2 = 12 minutes.
 * - The fourth mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
 * It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​
 * Example 2:
 *
 * Input: ranks = [5,1,8], cars = 6
 * Output: 16
 * Explanation: 
 * - The first mechanic will repair one car. The time required is 5 * 1 * 1 = 5 minutes.
 * - The second mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
 * - The third mechanic will repair one car. The time required is 8 * 1 * 1 = 8 minutes.
 * It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​
 *
 *
 * Constraints:
 *
 * 1 <= ranks.length <= 105
 * 1 <= ranks[i] <= 100
 * 1 <= cars <= 106
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarysearch;

public class _2594_Minimum_Time_to_Repair_Cars {

    public long repairCars(int[] ranks, int cars) {

        int max = 0;
        for (int rank : ranks) {
            max = Math.max(max, rank);
        }

        long l = 1;
        long r = (long) max * cars * cars;

        long result = -1;

        while (l <= r) {

            long mid = l + (r - l) / 2;

            if (isPossible(ranks, cars, mid)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }

    private boolean isPossible(int[] ranks, int cars, long target) {

        long carsFixed = 0;
        for (int rank : ranks) {

            // time = rank * cars * cars
            // cars = Math.sqrt (time / rank)
            carsFixed += Math.sqrt(target / rank);
        }

        return carsFixed >= cars;
    }
}

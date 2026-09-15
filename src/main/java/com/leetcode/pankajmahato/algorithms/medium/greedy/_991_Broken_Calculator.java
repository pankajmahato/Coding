/**********************************************************************************
 *
 * https://leetcode.com/problems/broken-calculator/
 *
 * There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:
 *
 * multiply the number on display by 2, or
 * subtract 1 from the number on display.
 * Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.
 *
 *
 *
 * Example 1:
 *
 * Input: startValue = 2, target = 3
 * Output: 2
 * Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
 * Example 2:
 *
 * Input: startValue = 5, target = 8
 * Output: 2
 * Explanation: Use decrement and then double {5 -> 4 -> 8}.
 * Example 3:
 *
 * Input: startValue = 3, target = 10
 * Output: 3
 * Explanation: Use double, decrement and double {3 -> 6 -> 5 -> 10}.
 *
 *
 * Constraints:
 *
 * 1 <= startValue, target <= 109
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.greedy;

public class _991_Broken_Calculator {

    public int brokenCalc(int startValue, int target) {

        // Instead of making start to target, make target as start by doing reverse operation
        int count = 0;
        while (target != startValue) {
            if (target > startValue && target % 2 == 0) {
                target = target / 2;
            } else if (startValue >= target) {
                count += startValue - target;
                break;
            } else {
                target++;
            }
            count++;
        }

        return count;
    }
}

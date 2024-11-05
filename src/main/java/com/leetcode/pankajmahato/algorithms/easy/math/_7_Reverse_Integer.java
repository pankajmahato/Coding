/**********************************************************************************
 *
 * https://leetcode.com/problems/reverse-integer/
 *
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 * Example 4:
 *
 * Input: x = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.math;

public class _7_Reverse_Integer {
    public int reverse(int x) {

        int num = x;
        int sum = 0;
        int r = 0;
        while (num != 0) {
            if (sum > Integer.MAX_VALUE / 10 || sum < Integer.MIN_VALUE / 10) {
                return 0;
            }
            r = num % 10;
            sum = r + sum * 10;
            num /= 10;
        }

        return sum;
    }
}

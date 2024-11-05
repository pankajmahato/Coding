/**********************************************************************************
 *
 * https://leetcode.com/problems/fibonacci-number/
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 *
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 *
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 * Constraints:
 *
 * 0 <= n <= 30
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.recursion;

import java.util.HashMap;
import java.util.Map;

public class _509_Fibonacci_Number {
    Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        map.put(0, 0);
        map.put(1, 1);

        return solve(n);
    }

    private int solve(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int n1 = map.get(n - 1) != null ? map.get(n - 1) : solve(n - 1);
        map.put(n - 1, n1);
        int n2 = map.get(n - 2) != null ? map.get(n - 2) : solve(n - 2);
        map.put(n - 2, n2);

        return n1 + n2;
    }
}

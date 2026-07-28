/**********************************************************************************
 *
 * https://leetcode.com/problems/sequential-digits/
 *
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 *
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 *
 *
 *
 * Example 1:
 *
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 *
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 *
 *
 * Constraints:
 *
 * 10 <= low <= high <= 10^9
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1291_Sequential_Digits {

    public List<Integer> sequentialDigits(int low, int high) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= 9; i++) {
            queue.add(i);
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            int val = queue.remove();
            if (val >= low && val <= high) {
                result.add(val);
            }

            int lastDigit = val % 10;
            if (lastDigit < 9) {
                int nextVal = val * 10 + lastDigit + 1;

                if (nextVal <= high) {
                    queue.add(nextVal);
                }
            }
        }

        return result;
    }
}

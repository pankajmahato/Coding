/**********************************************************************************
 *
 * https://leetcode.com/problems/combinations/
 *
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(1, n, k, temp, result);

        return result;
    }

    private void backtrack(int curr, int n, int k, List<Integer> temp, List<List<Integer>> result) {

        if (k == 0) {
            result.add(new ArrayList(temp));
        }

        for (int i = curr; i <= n; i++) {
            temp.add(i);
            backtrack(i + 1, n, k - 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}

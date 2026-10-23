/**********************************************************************************
 *
 * https://leetcode.com/problems/range-product-queries-of-powers/
 *
 * Given a positive integer n, there exists a 0-indexed array called powers, composed of the minimum number of powers of 2 that sum to n. The array is sorted in non-decreasing order, and there is only one way to form the array.
 *
 * You are also given a 0-indexed 2D integer array queries, where queries[i] = [lefti, righti]. Each queries[i] represents a query where you have to find the product of all powers[j] with lefti <= j <= righti.
 *
 * Return an array answers, equal in length to queries, where answers[i] is the answer to the ith query. Since the answer to the ith query may be too large, each answers[i] should be returned modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 15, queries = [[0,1],[2,2],[0,3]]
 * Output: [2,4,64]
 * Explanation:
 * For n = 15, powers = [1,2,4,8]. It can be shown that powers cannot be a smaller size.
 * Answer to 1st query: powers[0] * powers[1] = 1 * 2 = 2.
 * Answer to 2nd query: powers[2] = 4.
 * Answer to 3rd query: powers[0] * powers[1] * powers[2] * powers[3] = 1 * 2 * 4 * 8 = 64.
 * Each answer modulo 109 + 7 yields the same answer, so [2,4,64] is returned.
 * Example 2:
 *
 * Input: n = 2, queries = [[0,0]]
 * Output: [2]
 * Explanation:
 * For n = 2, powers = [2].
 * The answer to the only query is powers[0] = 2. The answer modulo 109 + 7 is the same, so [2] is returned.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 109
 * 1 <= queries.length <= 105
 * 0 <= starti <= endi < powers.length
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.ArrayList;
import java.util.List;

public class _2438_Range_Product_Queries_of_Powers {

    public int[] productQueries(int n, int[][] queries) {

        // Powers array is binary representation having only 1's bit from right to left
        int N = 32;
        List<Integer> powers = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            // i-th bit is set
            if ((n & (1 << i)) != 0) {
                // 2^i
                powers.add(1 << i);
            }
        }

        int MOD = (int) 1e9 + 7;
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {

            int left = queries[i][0];
            int right = queries[i][1];

            long product = 1;
            for (int j = left; j <= right; j++) {
                product = (product * powers.get(j)) % MOD;
            }

            result[i] = (int) product;
        }

        return result;
    }
}

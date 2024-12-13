/**********************************************************************************
 *
 * https://leetcode.com/problems/equal-row-and-column-pairs/
 *
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
 *
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
 * Output: 1
 * Explanation: There is 1 equal row and column pair:
 * - (Row 2, Column 1): [2,7,7]
 * Example 2:
 *
 *
 * Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * Output: 3
 * Explanation: There are 3 equal row and column pairs:
 * - (Row 0, Column 0): [3,1,2,2]
 * - (Row 2, Column 2): [2,4,2,2]
 * - (Row 3, Column 2): [2,4,2,2]
 *
 *
 * Constraints:
 *
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * 1 <= grid[i][j] <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2352_Equal_Row_and_Column_Pairs {

    public int equalPairs(int[][] grid) {

        // key = Row[]; val = count;
        Map<List<Integer>, Integer> map = new HashMap<>();

        for (int[] row : grid) {
            List<Integer> arr = new ArrayList<>();
            for (int num : row) {
                arr.add(num);
            }

            map.put(arr, map.getOrDefault(arr, 0) + 1);
        }

        int count = 0;
        for (int c = 0; c < grid.length; c++) {
            List<Integer> arr = new ArrayList<>();
            for (int r = 0; r < grid.length; r++) {
                arr.add(grid[r][c]);
            }

            count += map.getOrDefault(arr, 0);
        }

        return count;
    }
}

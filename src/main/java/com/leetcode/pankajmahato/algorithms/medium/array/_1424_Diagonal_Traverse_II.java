/**********************************************************************************
 *
 * https://leetcode.com/problems/diagonal-traverse-ii/
 *
 * Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,4,2,7,5,3,8,6,9]
 * Example 2:
 *
 *
 * Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
 * Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i].length <= 105
 * 1 <= sum(nums[i].length) <= 105
 * 1 <= nums[i][j] <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1424_Diagonal_Traverse_II {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        Queue<int[]> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {

            int[] val = queue.remove();
            int r = val[0];
            int c = val[1];

            result.add(nums.get(r).get(c));

            if (c == 0) {
                int x = r + 1;
                int y = 0;

                if (x < nums.size()) {
                    queue.add(new int[]{x, y});
                }
            }
            int x = r;
            int y = c + 1;

            if (x < nums.size() && y < nums.get(x).size()) {
                queue.add(new int[]{x, y});
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }
}

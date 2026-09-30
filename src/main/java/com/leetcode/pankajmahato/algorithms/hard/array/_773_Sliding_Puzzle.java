/**********************************************************************************
 *
 * https://leetcode.com/problems/sliding-puzzle/
 *
 * On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0. A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 *
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 *
 * Given the puzzle board board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * Example 2:
 *
 *
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * Example 3:
 *
 *
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 *
 *
 * Constraints:
 *
 * board.length == 2
 * board[i].length == 3
 * 0 <= board[i][j] <= 5
 * Each value board[i][j] is unique.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _773_Sliding_Puzzle {

    public int slidingPuzzle(int[][] board) {

        // Convert to string representation
        String start = "";
        for (int[] row : board) {
            for (int col : row) {
                start = start + col;
            }
        }

        // Convert 4-direction move of matrix to string index for all positions of '0'
        int[][] directions = new int[][]{
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4},
                {1, 3, 5},
                {2, 4}
        };

        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        Set<String> visited = new HashSet<>();
        visited.add(start);

        String target = "123450";

        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.remove();

                if (curr.equals(target)) {
                    return level;
                }

                int idx = curr.indexOf("0");

                for (int swapIdx : directions[idx]) {
                    String next = swap(curr, idx, swapIdx);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }

            level++;
        }

        return -1;
    }

    private String swap(String str, int idx, int swapIdx) {

        char[] result = str.toCharArray();
        char c = result[idx];
        result[idx] = result[swapIdx];
        result[swapIdx] = c;

        return String.valueOf(result);
    }
}

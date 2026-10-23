/**********************************************************************************
 *
 * https://leetcode.com/problems/shortest-path-to-get-all-keys/
 *
 * You are given an m x n grid grid where:
 *
 * '.' is an empty cell.
 * '#' is a wall.
 * '@' is the starting point.
 * Lowercase letters represent keys.
 * Uppercase letters represent locks.
 * You start at the starting point and one move consists of walking one space in one of the four cardinal directions. You cannot walk outside the grid, or walk into a wall.
 *
 * If you walk over a key, you can pick it up and you cannot walk over a lock unless you have its corresponding key.
 *
 * For some 1 <= k <= 6, there is exactly one lowercase and one uppercase letter of the first k letters of the English alphabet in the grid. This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.
 *
 * Return the lowest number of moves to acquire all keys. If it is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = ["@.a..","###.#","b.A.B"]
 * Output: 8
 * Explanation: Note that the goal is to obtain all the keys not to open all the locks.
 * Example 2:
 *
 *
 * Input: grid = ["@..aA","..B#.","....b"]
 * Output: 6
 * Example 3:
 *
 *
 * Input: grid = ["@Aa"]
 * Output: -1
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 30
 * grid[i][j] is either an English letter, '.', '#', or '@'. 
 * There is exactly one '@' in the grid.
 * The number of keys in the grid is in the range [1, 6].
 * Each key in the grid is unique.
 * Each key in the grid has a matching lock.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.array;

import java.util.LinkedList;
import java.util.Queue;

public class _864_Shortest_Path_to_Get_All_Keys {

    public int shortestPathAllKeys(String[] grid) {

        int rows = grid.length;
        int cols = grid[0].length();
        int keyCount = 0;

        int[][] directions = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};

        // {i, j, steps, keyStatus}
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    queue.add(new int[]{i, j, 0, 0});
                } else if (ch >= 'a' && ch <= 'f') {
                    keyCount++;
                }
            }
        }

        // Key status is '1's bit position in decimal
        // 000001 -> 'a' -> 1
        // 000010 -> 'b' -> 2
        // 000100 -> 'c' -> 4
        // 001000 -> 'd' -> 8
        // 010000 -> 'e' -> 16
        // 100000 -> 'f' -> 32
        // Final status is all '1's --> 111111 -> 63
        int finalKeyStatus = (int) Math.pow(2, keyCount) - 1;

        boolean[][][] visited = new boolean[rows][cols][finalKeyStatus + 1];

        while (!queue.isEmpty()) {

            int[] val = queue.remove();
            int i = val[0];
            int j = val[1];
            int steps = val[2];
            int currentKeyStatus = val[3];

            if (currentKeyStatus == finalKeyStatus) {
                return steps;
            }

            for (int[] dir : directions) {

                int x = i + dir[0];
                int y = j + dir[1];

                if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x].charAt(y) != '#') {

                    char ch = grid[x].charAt(y);

                    if (ch >= 'A' && ch <= 'F') { // Lock

                        boolean hasKey = ((currentKeyStatus >> (ch - 'A')) & 1) == 1;

                        if (visited[x][y][currentKeyStatus] == false && hasKey) {
                            visited[x][y][currentKeyStatus] = true;
                            queue.add(new int[]{x, y, steps + 1, currentKeyStatus});
                        }

                    } else if (ch >= 'a' && ch <= 'f') { // Key

                        int newKeyStatus = currentKeyStatus | (1 << (ch - 'a'));

                        if (visited[x][y][newKeyStatus] == false) {
                            visited[x][y][newKeyStatus] = true;
                            queue.add(new int[]{x, y, steps + 1, newKeyStatus});
                        }

                    } else { // '.'

                        if (visited[x][y][currentKeyStatus] == false) {
                            visited[x][y][currentKeyStatus] = true;
                            queue.add(new int[]{x, y, steps + 1, currentKeyStatus});
                        }
                    }
                }
            }
        }

        return -1;
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 * Example 1:
 *
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 *
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 *
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.HashSet;
import java.util.Set;

public class _36_Valid_Sudoku {
//    public boolean isValidSudoku(char[][] board) {
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if (board[i][j] != '.' && !isValid(board, i, j)) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
//
//    public boolean isValid(char[][] board, int row, int col) {
//
//        for (int j = 0; j < board[row].length; j++) {
//            if (j != col && board[row][j] == board[row][col]) {
//                return false;
//            }
//        }
//
//        for (int i = 0; i < board.length; i++) {
//            if (i != row && board[i][col] == board[row][col]) {
//                return false;
//            }
//        }
//
//        int x = row / 3 * 3;
//        int y = col / 3 * 3;
//
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if ((x + i) != row && (y + j) != col && board[x + i][y + j] == board[row][col]) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }

    public boolean isValidSudoku(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        Set<String> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                String row = board[i][j] + "_ROW_" + i;
                String col = board[i][j] + "_COL_" + j;
                String box = board[i][j] + "_box_" + i / 3 + "_" + j / 3;

                if (set.contains(row) || set.contains(col) || set.contains(box)) {
                    return false;
                }

                set.add(row);
                set.add(col);
                set.add(box);
            }
        }

        return true;
    }
}

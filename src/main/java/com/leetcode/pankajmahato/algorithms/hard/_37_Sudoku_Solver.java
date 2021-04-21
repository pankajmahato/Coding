/**********************************************************************************
 *
 * https://leetcode.com/problems/sudoku-solver/
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * Explanation: The input board is shown above and the only valid solution is shown below:
 *
 *
 *
 *
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 * It is guaranteed that the input board has only one solution.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard;

public class _37_Sudoku_Solver {
    public void solveSudoku(char[][] board) {

        solve(board, 0, 0);
    }

    public boolean solve(char[][] board, int i, int j) {

        if (i == board.length) {
            return true;
        }

        int ni = 0;
        int nj = 0;

        if (j == board[0].length - 1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }

        if (board[i][j] != '.') {
            return solve(board, ni, nj);
        } else {
            for (char posVal = '1'; posVal <= '9'; posVal++) {
                if (isValid(board, i, j, posVal)) {
                    board[i][j] = posVal;
                    boolean solved = solve(board, ni, nj);
                    if (solved) {
                        return true;
                    } else {
                        board[i][j] = '.';
                    }
                }
            }
        }

        return false;
    }

    public boolean isValid(char[][] board, int row, int col, char val) {

        for (int j = 0; j < board[row].length; j++) {
            if (board[row][j] == val) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == val) {
                return false;
            }
        }

        int x = row / 3 * 3;
        int y = col / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[x + i][y + j] == val) {
                    return false;
                }
            }
        }

        return true;
    }
}

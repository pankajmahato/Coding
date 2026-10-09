/**********************************************************************************
 *
 * https://leetcode.com/problems/n-queens/
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * Example 2:
 *
 * Input: n = 1
 * Output: [["Q"]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _51_N_Queens {

    // public List<List<String>> solveNQueens(int n) {

    //     char[][] board = new char[n][n];
    //     for (char[] b : board) {
    //         Arrays.fill(b, '.');
    //     }

    //     List<List<String>> result = new ArrayList<>();

    //     solve(n, board, 0, result);

    //     return result;
    // }

    // private void solve(int n, char[][] board, int row, List<List<String>> result) {

    //     if (row >= n) {

    //         List<String> res = new ArrayList<>();
    //         for (int i = 0; i < n; i++) {
    //             res.add(new String(board[i]));
    //         }
    //         result.add(res);
    //     }

    //     for (int col = 0; col < n; col++) {

    //         if (isValid(n, board, row, col)) {

    //             board[row][col] = 'Q';
    //             solve(n, board, row + 1, result);
    //             board[row][col] = '.';
    //         }
    //     }
    // }

    // private boolean isValid(int n, char[][] board, int row, int col) {

    //     // Check up
    //     for (int i = row - 1; i >= 0; i--) {
    //         if (board[i][col] == 'Q') {
    //             return false;
    //         }
    //     }

    //     // Check left diagonal
    //     for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
    //         if (board[i][j] == 'Q') {
    //             return false;
    //         }
    //     }

    //     // Check right diagonal
    //     for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
    //         if (board[i][j] == 'Q') {
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        for (char[] b : board) {
            Arrays.fill(b, '.');
        }

        List<List<String>> result = new ArrayList<>();

        Set<Integer> columnsVisited = new HashSet<>();
        // All right diagonals have (i+j) constant
        Set<Integer> diagonalVisited = new HashSet<>();
        // All left diagonals have (i-j) constant
        Set<Integer> leftDiagonalVisited = new HashSet<>();

        solve(n, board, 0, result, columnsVisited, diagonalVisited, leftDiagonalVisited);

        return result;
    }

    private void solve(int n, char[][] board, int row, List<List<String>> result, Set<Integer> columnsVisited,
                       Set<Integer> diagonalVisited, Set<Integer> leftDiagonalVisited) {

        if (row >= n) {

            List<String> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                res.add(new String(board[i]));
            }
            result.add(res);
        }

        for (int col = 0; col < n; col++) {

            if (isValid(n, board, row, col, columnsVisited, diagonalVisited, leftDiagonalVisited)) {

                board[row][col] = 'Q';

                columnsVisited.add(col);
                diagonalVisited.add(row + col);
                leftDiagonalVisited.add(row - col);

                solve(n, board, row + 1, result, columnsVisited, diagonalVisited, leftDiagonalVisited);

                board[row][col] = '.';

                columnsVisited.remove(col);
                diagonalVisited.remove(row + col);
                leftDiagonalVisited.remove(row - col);
            }
        }
    }

    private boolean isValid(int n, char[][] board, int row, int col, Set<Integer> columnsVisited,
                            Set<Integer> diagonalVisited, Set<Integer> leftDiagonalVisited) {

        // Check up
        if (columnsVisited.contains(col)) {
            return false;
        }

        // Check left diagonal
        if (diagonalVisited.contains(row + col)) {
            return false;
        }

        // Check right diagonal
        if (leftDiagonalVisited.contains(row - col)) {
            return false;
        }

        return true;
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/all-possible-full-binary-trees/
 *
 * On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).
 *
 * A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.
 *
 *
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
 *
 * The knight continues moving until it has made exactly k moves or has moved off the chessboard.
 *
 * Return the probability that the knight remains on the board after it has stopped moving.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, k = 2, row = 0, column = 0
 * Output: 0.06250
 * Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
 * From each of those positions, there are also two moves that will keep the knight on the board.
 * The total probability the knight stays on the board is 0.0625.
 * Example 2:
 *
 * Input: n = 1, k = 0, row = 0, column = 0
 * Output: 1.00000
 *
 *
 * Constraints:
 *
 * 1 <= n <= 25
 * 0 <= k <= 100
 * 0 <= row, column <= n - 1
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _894_All_Possible_Full_Binary_Trees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> allPossibleFBT(int n) {

        // DP Top Down

        // Key -> number of nodes
        // Value -> Full Binary Tree
        Map<Integer, List<TreeNode>> dp = new HashMap<>();

        return solve(n, dp);
    }

    private List<TreeNode> solve(int n, Map<Integer, List<TreeNode>> dp) {

        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        if (n == 1) {
            TreeNode root = new TreeNode(0);
            List<TreeNode> result = new ArrayList<>();
            result.add(root);

            return result;
        }

        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        List<TreeNode> result = new ArrayList<>();

        for (int i = 1; i < n; i += 2) {

            List<TreeNode> allLeftFBT = solve(i, dp);
            List<TreeNode> allRightFBT = solve(n - i - 1, dp);

            for (TreeNode left : allLeftFBT) {
                for (TreeNode right : allRightFBT) {

                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;

                    result.add(root);
                }
            }

        }

        dp.put(n, result);
        return result;
    }
}

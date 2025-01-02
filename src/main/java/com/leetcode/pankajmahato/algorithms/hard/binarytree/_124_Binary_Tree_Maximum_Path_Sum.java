/**********************************************************************************
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * Example 2:
 *
 *
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -1000 <= Node.val <= 1000
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.binarytree;

public class _124_Binary_Tree_Maximum_Path_Sum {

    class TreeNode {
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

    int maxSum;

    public int maxPathSum(TreeNode root) {

        maxSum = Integer.MIN_VALUE;

        solve(root);

        return maxSum;
    }

    private int solve(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftSum = solve(root.left);
        int rightSum = solve(root.right);

        // Path is coming from left then root and then to right
        int sumBelow = leftSum + rightSum + root.val;

        // Path is coming from either left of right and goes up
        int sumEitherLeftOrRight = Math.max(leftSum, rightSum) + root.val;

        // Path starts from root
        int onlyRoot = root.val;

        maxSum = Math.max(maxSum, Math.max(sumBelow, Math.max(sumEitherLeftOrRight, onlyRoot)));

        return Math.max(sumEitherLeftOrRight, onlyRoot);

    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 *
 * Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
 *
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation: We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 * Example 2:
 *
 *
 * Input: root = [1,null,2,null,0,3]
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 5000].
 * 0 <= Node.val <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarytree;

public class _1026_Maximum_Difference_Between_Node_and_Ancestor {

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

    public int maxAncestorDiff(TreeNode root) {

        int minValue = 1_000_000;
        int maxValue = -1;

        return findMaxDiff(root, maxValue, minValue);
    }

    private int findMaxDiff(TreeNode root, int maxValue, int minValue) {

        if (root == null) {
            return Math.abs(maxValue - minValue);
        }

        maxValue = Math.max(maxValue, root.val);
        minValue = Math.min(minValue, root.val);

        int left = findMaxDiff(root.left, maxValue, minValue);
        int right = findMaxDiff(root.right, maxValue, minValue);

        return Math.max(left, right);
    }
}

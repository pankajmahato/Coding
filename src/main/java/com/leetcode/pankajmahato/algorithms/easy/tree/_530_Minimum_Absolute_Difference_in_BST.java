/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 *
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 104].
 * 0 <= Node.val <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.tree;


public class _530_Minimum_Absolute_Difference_in_BST {


    //Definition for a binary tree node.
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

    TreeNode prev = null;
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        prev = null;
        inorder(root);

        return result;
    }

    private void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null) {
            result = Math.min(result, root.val - prev.val);
        }

        prev = root;
        inorder(root.right);
    }
}

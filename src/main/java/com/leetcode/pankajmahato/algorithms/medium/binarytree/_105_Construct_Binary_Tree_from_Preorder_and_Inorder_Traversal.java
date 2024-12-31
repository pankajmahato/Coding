/**********************************************************************************
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarytree;

public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;
        int[] idx = {0};

        return solve(preorder, inorder, 0, n - 1, idx);
    }

    private TreeNode solve(int[] preorder, int[] inorder, int start, int end, int[] idx) {

        if (start > end) {
            return null;
        }

        int i = start;
        for (; i <= end; i++) {
            if (inorder[i] == preorder[idx[0]]) {
                break;
            }
        }

        TreeNode root = new TreeNode(preorder[idx[0]]);
        idx[0]++;
        root.left = solve(preorder, inorder, start, i - 1, idx);
        root.right = solve(preorder, inorder, i + 1, end, idx);

        return root;
    }
}

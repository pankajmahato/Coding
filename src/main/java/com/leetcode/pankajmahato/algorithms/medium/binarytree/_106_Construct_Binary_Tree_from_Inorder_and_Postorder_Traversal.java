/**********************************************************************************
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarytree;

public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int n = inorder.length;

        int inStart = 0;
        int inEnd = n - 1;
        int postStart = 0;
        int postEnd = n - 1;

        return solve(inorder, postorder, inStart, inEnd, postStart, postEnd);
    }

    private TreeNode solve(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int i = inStart;
        for (; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                break;
            }
        }

        int leftSize = i - inStart;
        int rightSize = inEnd - i;

        root.left = solve(inorder, postorder, inStart, i - 1, postStart, postStart + leftSize - 1);
        root.right = solve(inorder, postorder, i + 1, inEnd, postEnd - rightSize, postEnd - 1);

        return root;
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 *
 * Output: [1,2,3]
 *
 * Explanation:
 *
 *
 *
 * Example 2:
 *
 * Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
 *
 * Output: [1,2,4,5,6,7,3,8,9]
 *
 * Explanation:
 *
 *
 *
 * Example 3:
 *
 * Input: root = []
 *
 * Output: []
 *
 * Example 4:
 *
 * Input: root = [1]
 *
 * Output: [1]
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_Binary_Tree_Preorder_Traversal {

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

//    public List<Integer> preorderTraversal(TreeNode root) {
//
//        // Recursion
//        List<Integer> result = new ArrayList<>();
//
//        solve(root, result);
//        return result;
//    }
//
//    private void solve(TreeNode root, List<Integer> result) {
//
//        if (root == null) {
//            return;
//        }
//
//        result.add(root.val);
//        solve(root.left, result);
//        solve(root.right, result);
//    }

    public List<Integer> preorderTraversal(TreeNode root) {

        // Iterative
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }
}

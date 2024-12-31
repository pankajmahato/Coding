/**********************************************************************************
 *
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 *
 * Given the root of a binary tree, determine if it is a complete binary tree.
 *
 * In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 * Example 2:
 *
 *
 * Input: root = [1,2,3,4,5,null,7]
 * Output: false
 * Explanation: The node with value 7 isn't as far left as possible.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 100].
 * 1 <= Node.val <= 1000
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class _958_Check_Completeness_of_a_Binary_Tree {

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

//    public boolean isCompleteTree(TreeNode root) {
//
//        // BFS
//        boolean hasSeenNull = false;
//
//        // ArrayDeque doesn't support NULL values
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//
//            TreeNode node = queue.remove();
//
//            if (node == null) {
//                hasSeenNull = true;
//            } else {
//                if (hasSeenNull == true) {
//                    return false;
//                }
//                queue.add(node.left);
//                queue.add(node.right);
//            }
//        }
//
//        return true;
//    }

    public boolean isCompleteTree(TreeNode root) {

        // DFS
        int n = countNodes(root);

        return dfs(root, 1, n);
    }

    private int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private boolean dfs(TreeNode root, int idx, int count) {

        if (root == null) {
            return true;
        }

        if (idx > count) {
            return false;
        }

        return dfs(root.left, 2 * idx, count) && dfs(root.right, 2 * idx + 1, count);
    }
}

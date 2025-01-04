/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * Example 2:
 *
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 105].
 * -1000 <= Node.val <= 1000
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class _111_Minimum_Depth_of_Binary_Tree {

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

//    int minDepth;
//
//    public int minDepth(TreeNode root) {
//
//        // DFS
//        if (root == null) {
//            return 0;
//        }
//
//        minDepth = Integer.MAX_VALUE;
//        dfs(root, 1);
//        return minDepth;
//    }
//
//    private void dfs(TreeNode root, int level) {
//
//        if (root == null) {
//            return;
//        }
//
//        if (root.left == null && root.right == null) {
//            minDepth = Math.min(minDepth, level);
//            return;
//        }
//
//        dfs(root.left, level + 1);
//        dfs(root.right, level + 1);
//    }

    public int minDepth(TreeNode root) {

        // BFS
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {

            int n = queue.size();
            level++;

            while (n-- > 0) {

                TreeNode node = queue.remove();

                if (node.left == null && node.right == null) {
                    return level;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return 0;
    }
}

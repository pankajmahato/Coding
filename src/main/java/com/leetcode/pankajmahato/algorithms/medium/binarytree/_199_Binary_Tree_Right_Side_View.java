/**********************************************************************************
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,null,5,null,4]
 *
 * Output: [1,3,4]
 *
 * Explanation:
 *
 *
 *
 * Example 2:
 *
 * Input: root = [1,2,3,4,null,null,null,5]
 *
 * Output: [1,3,4,5]
 *
 * Explanation:
 *
 *
 *
 * Example 3:
 *
 * Input: root = [1,null,3]
 *
 * Output: [1,3]
 *
 * Example 4:
 *
 * Input: root = []
 *
 * Output: []
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _199_Binary_Tree_Right_Side_View {

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

//    public List<Integer> rightSideView(TreeNode root) {
//
//        // BFS
//        List<Integer> result = new ArrayList<>();
//
//        if (root == null) {
//            return result;
//        }
//
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//
//            int n = queue.size();
//            TreeNode node = null;
//            while (n-- > 0) {
//                node = queue.remove();
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//
//            result.add(node.val);
//        }
//
//        return result;
//    }

    public List<Integer> rightSideView(TreeNode root) {

        // DFS
        List<Integer> result = new ArrayList<>();

        solve(root, 0, result);

        return result;
    }

    private void solve(TreeNode root, int level, List<Integer> result) {

        if (root == null) {
            return;
        }

        if (result.size() == level) {
            result.add(root.val);
        }

        solve(root.right, level + 1, result);
        solve(root.left, level + 1, result);
    }
}

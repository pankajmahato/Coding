/**********************************************************************************
 *
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 *
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 * Example 2:
 *
 * Input: root = [1,2,3]
 * Output: [1,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree will be in the range [0, 104].
 * -231 <= Node.val <= 231 - 1
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarytree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class _515_Find_Largest_Value_in_Each_Tree_Row {


    static class TreeNode {
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


//    public List<Integer> largestValues(TreeNode root) {
//
//        // BFS
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        Set<Integer> visited = new HashSet<>();
//
//        if (root == null) {
//            return new ArrayList<>();
//        }
//
//        List<Integer> result = new ArrayList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//
//            int n = queue.size();
//            int max = Integer.MIN_VALUE;
//
//            while (n-- > 0) {
//
//                TreeNode node = queue.remove();
//                max = Math.max(max, node.val);
//
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//
//            result.add(max);
//        }
//
//        return result;
//    }

    public List<Integer> largestValues(TreeNode root) {

        // DFS
        List<Integer> result = new ArrayList<>();

        dfs(root, 0, result);

        return result;
    }

    private void dfs(TreeNode root, int depth, List<Integer> result) {

        if (root == null) {
            return;
        }

        if (result.size() == depth) {
            result.add(root.val);
        } else {
            result.set(depth, Math.max(root.val, result.get(depth)));
        }

        dfs(root.left, depth + 1, result);
        dfs(root.right, depth + 1, result);
    }
}

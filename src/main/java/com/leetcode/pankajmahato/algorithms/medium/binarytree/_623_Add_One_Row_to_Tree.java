/**********************************************************************************
 *
 * https://leetcode.com/problems/add-one-row-to-tree/
 *
 * Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.
 *
 * Note that the root node is at depth 1.
 *
 * The adding rule is:
 *
 * Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
 * cur's original left subtree should be the left subtree of the new left subtree root.
 * cur's original right subtree should be the right subtree of the new right subtree root.
 * If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,6,3,1,5], val = 1, depth = 2
 * Output: [4,1,1,2,null,null,6,3,1,5]
 * Example 2:
 *
 *
 * Input: root = [4,2,null,3,1], val = 1, depth = 3
 * Output: [4,2,null,1,1,3,null,null,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * The depth of the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
 * -105 <= val <= 105
 * 1 <= depth <= the depth of tree + 1
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class _623_Add_One_Row_to_Tree {

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

//    public TreeNode addOneRow(TreeNode root, int val, int depth) {
//
//        // DFS
//        if (depth == 1) {
//            TreeNode temp = new TreeNode(val);
//            temp.left = root;
//
//            return temp;
//        }
//
//        int curr = 1;
//        addOneRow(root, val, depth, curr);
//
//        return root;
//    }
//
//    private TreeNode addOneRow(TreeNode root, int val, int depth, int curr) {
//
//        if (root == null) {
//            return null;
//        }
//
//        if (curr == depth - 1) {
//            TreeNode left = root.left;
//            TreeNode right = root.right;
//
//            TreeNode newLeft = new TreeNode(val);
//            TreeNode newRight = new TreeNode(val);
//            newLeft.left = left;
//            newRight.right = right;
//
//            root.left = newLeft;
//            root.right = newRight;
//
//            return root;
//        }
//
//        if (curr >= depth) {
//            return root;
//        }
//
//        root.left = addOneRow(root.left, val, depth, curr + 1);
//        root.right = addOneRow(root.right, val, depth, curr + 1);
//
//        return root;
//    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        // BFS
        if (depth == 1) {
            TreeNode temp = new TreeNode(val);
            temp.left = root;

            return temp;
        }

        int level = 1;
        boolean rowAdded = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int n = queue.size();

            while (n-- > 0) {
                TreeNode node = queue.remove();
                TreeNode left = node.left;
                TreeNode right = node.right;

                if (level == depth - 1) {
                    TreeNode newLeft = new TreeNode(val);
                    TreeNode newRight = new TreeNode(val);
                    newLeft.left = left;
                    newRight.right = right;

                    node.left = newLeft;
                    node.right = newRight;
                    rowAdded = true;
                }
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
            }
            if (rowAdded) {
                break;
            }
            level++;
        }

        return root;
    }
}

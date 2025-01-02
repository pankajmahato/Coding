/**********************************************************************************
 *
 * https://leetcode.com/problems/same-tree/
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 *
 *
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class _100_Same_Tree {

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

//    public boolean isSameTree(TreeNode p, TreeNode q) {
//
//        // DFS
//        if (p == null && q == null) {
//            return true;
//        }
//
//        if ((p == null && q != null) || (p != null && q == null)) {
//            return false;
//        }
//
//        if (p.val != q.val) {
//            return false;
//        }
//
//        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // BFS
        if (p == null && q == null) {
            return true;
        }

        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.add(p);
        qQueue.add(q);

        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {

            TreeNode pNode = pQueue.remove();
            TreeNode qNode = qQueue.remove();

            if (pNode.val != qNode.val) {
                return false;
            }

            if (pNode.left != null && qNode.left != null) {
                pQueue.add(pNode.left);
                qQueue.add(qNode.left);
            } else if (pNode.left != null || qNode.left != null) {
                return false;
            }

            if (pNode.right != null && qNode.right != null) {
                pQueue.add(pNode.right);
                qQueue.add(qNode.right);
            } else if (pNode.right != null || qNode.right != null) {
                return false;
            }
        }

        return true;
    }
}

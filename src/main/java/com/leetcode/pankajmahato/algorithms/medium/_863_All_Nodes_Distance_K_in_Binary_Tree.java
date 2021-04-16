/**********************************************************************************
 *
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 *
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 *
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 *
 * Output: [7,4,1]
 *
 * Explanation:
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 *
 *
 *
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these objects.
 *
 *
 * Note:
 *
 * The given tree is non-empty.
 * Each node in the tree has unique values 0 <= node.val <= 500.
 * The target node is a node in the tree.
 * 0 <= K <= 1000.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;

import java.util.*;

public class _863_All_Nodes_Distance_K_in_Binary_Tree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        HashSet<TreeNode> visited = new HashSet<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        fillParent(root, null, parent);
        getKNodes(root, target, K, queue, visited, parent, result);

        return result;
    }

    private TreeNode fillParent(TreeNode node, TreeNode p, HashMap<TreeNode, TreeNode> parent) {

        if (node == null) {
            return null;
        }
        parent.put(node, p);

        fillParent(node.left, node, parent);
        fillParent(node.right, node, parent);

        return null;
    }

    private void getKNodes(TreeNode root, TreeNode target, int k, LinkedList<TreeNode> queue, HashSet<TreeNode> visited, HashMap<TreeNode, TreeNode> parent, List<Integer> result) {

        TreeNode node = getNode(root, target);

        queue.add(node);
        visited.add(node);

        int level = 0;

        while (!queue.isEmpty()) {
            if (level == k) {
                for (TreeNode t : queue) {
                    result.add(t.val);
                }
                return;
            }

            fillLevel(queue, visited, parent);
            level++;

        }
    }

    private TreeNode getNode(TreeNode root, TreeNode target) {

        if (root == null) {
            return null;
        }

        if (root.val == target.val) {
            return root;
        }

        TreeNode left = getNode(root.left, target);
        if (left != null) {
            return left;
        }

        TreeNode right = getNode(root.right, target);
        if (right != null) {
            return right;
        }

        return null;
    }

    private void fillLevel(LinkedList<TreeNode> queue, HashSet<TreeNode> visited, HashMap<TreeNode, TreeNode> parent) {

        queue.add(null);
        while (!queue.isEmpty()) {

            TreeNode node = queue.removeFirst();
            if (node == null) {
                break;
            }

            if (node.left != null && !visited.contains(node.left)) {
                queue.add(node.left);
                visited.add(node.left);
            }
            if (node.right != null && !visited.contains(node.right)) {
                queue.add(node.right);
                visited.add(node.right);
            }
            if (parent.get(node) != null && !visited.contains(parent.get(node))) {
                queue.add(parent.get(node));
                visited.add(parent.get(node));
            }
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

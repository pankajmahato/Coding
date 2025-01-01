/**********************************************************************************
 *
 * https://leetcode.com/problems/leaf-similar-trees/
 *
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 *
 *
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * Output: true
 * Example 2:
 *
 *
 * Input: root1 = [1,2,3], root2 = [1,3,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in each tree will be in the range [1, 200].
 * Both of the given trees will have values in the range [0, 200].
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.binarytree;

import java.util.ArrayList;
import java.util.List;

public class _872_Leaf_Similar_Trees {

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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();

        getLeafNodes(root1, leaf1);
        getLeafNodes(root2, leaf2);

        if (leaf1.size() != leaf2.size()) {
            return false;
        }

        for (int i = 0; i < leaf1.size(); i++) {
            // Using equals due to Integer object caching
            if (!leaf1.get(i).equals(leaf2.get(i))) {
                return false;
            }
        }

        return true;
    }

    private void getLeafNodes(TreeNode root, List<Integer> leaf) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leaf.add(root.val);
        }

        getLeafNodes(root.left, leaf);
        getLeafNodes(root.right, leaf);
    }
}

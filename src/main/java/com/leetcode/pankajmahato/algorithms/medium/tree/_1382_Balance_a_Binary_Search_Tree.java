/**********************************************************************************
 *
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 *
 * Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.
 *
 * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,null,3,null,4,null,null]
 * Output: [2,1,3,null,null,null,4]
 * Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
 * Example 2:
 *
 *
 * Input: root = [2,1,3]
 * Output: [2,1,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.tree;


import java.util.ArrayList;
import java.util.List;

public class _1382_Balance_a_Binary_Search_Tree {


    //Definition for a binary tree node.
    public class TreeNode {
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

    public TreeNode balanceBST(TreeNode root) {

        List<Integer> nums = new ArrayList<>();

        // Get in ascending order
        inorder(root, nums);

        return solve(0, nums.size() - 1, nums);
    }

    private void inorder(TreeNode root, List<Integer> nums) {

        if (root == null) {
            return;
        }

        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    private TreeNode solve(int l, int r, List<Integer> nums) {

        if (l > r) {
            return null;
        }

        int mid = l + (r - l) / 2;

        TreeNode root = new TreeNode(nums.get(mid));
        root.left = solve(l, mid - 1, nums);
        root.right = solve(mid + 1, r, nums);

        return root;
    }
}

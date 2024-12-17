/**********************************************************************************
 *
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 *
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
 *
 * If the tree has more than one mode, return them in any order.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: root = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 *
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.tree;


import java.util.ArrayList;
import java.util.List;

public class _501_Find_Mode_in_Binary_Search_Tree {


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

    int currNum = Integer.MIN_VALUE;
    int currFreq = 0;
    int maxFreq = 0;
    List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {

        inorder(root);

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;

        // Java Streams are slower than for loop
        // return result.stream().mapToInt(i -> i).toArray();
    }

    private void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        if (currNum == root.val) {
            currFreq++;
        } else {
            currNum = root.val;
            currFreq = 1;
        }

        if (currFreq > maxFreq) {
            maxFreq = currFreq;
            result.clear();
            result.add(currNum);
        } else if (currFreq == maxFreq) {
            result.add(currNum);
        }

        inorder(root.right);
    }
}

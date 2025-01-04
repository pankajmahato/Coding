/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 *
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation: 
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 * Example 2:
 *
 * Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class _1161_Maximum_Level_Sum_of_a_Binary_Tree {

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

    public int maxLevelSum(TreeNode root) {

        // BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        long maxSum = Long.MIN_VALUE;
        int minLevel = Integer.MAX_VALUE;
        int currLevel = 0;

        while (!queue.isEmpty()) {

            int n = queue.size();

            currLevel++;
            long currSum = 0;
            while (n-- > 0) {

                TreeNode node = queue.remove();
                currSum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (maxSum < currSum) {
                maxSum = currSum;
                minLevel = currLevel;
            }
        }

        return minLevel;
    }
}

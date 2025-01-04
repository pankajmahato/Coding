/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 *
 * Given the root of a binary tree, return the maximum width of the given tree.
 *
 * The maximum width of a tree is the maximum width among all levels.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
 *
 * It is guaranteed that the answer will in the range of a 32-bit signed integer.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,3,2,5,3,null,9]
 * Output: 4
 * Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
 * Example 2:
 *
 *
 * Input: root = [1,3,2,5,null,null,9,6,null,7]
 * Output: 7
 * Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
 * Example 3:
 *
 *
 * Input: root = [1,3,2,5]
 * Output: 2
 * Explanation: The maximum width exists in the second level with length 2 (3,2).
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 3000].
 * -100 <= Node.val <= 100
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

public class _662_Maximum_Width_of_Binary_Tree {

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

    class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int result = 0;
        int idx = 0;

        Deque<Pair> deque = new ArrayDeque<>();
        deque.add(new Pair(root, idx));

        while (!deque.isEmpty()) {

            int n = deque.size();
            Pair first = deque.peekFirst();
            Pair last = deque.peekLast();

            result = Math.max(result, last.index - first.index + 1);

            while (n-- > 0) {

                Pair p = deque.removeFirst();
                idx = p.index;
                if (p.node.left != null) {
                    deque.add(new Pair(p.node.left, 2 * idx + 1));
                }
                if (p.node.right != null) {
                    deque.add(new Pair(p.node.right, 2 * idx + 2));
                }
            }
        }

        return result;
    }
}

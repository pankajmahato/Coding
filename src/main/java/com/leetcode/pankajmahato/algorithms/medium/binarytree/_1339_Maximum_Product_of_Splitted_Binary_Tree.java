/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 *
 * Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.
 *
 * Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.
 *
 * Note that you need to maximize the answer before taking the mod and not after taking it.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,6]
 * Output: 110
 * Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
 * Example 2:
 *
 *
 * Input: root = [1,null,2,3,4,null,null,5,6]
 * Output: 90
 * Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 5 * 104].
 * 1 <= Node.val <= 104
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarytree;

public class _1339_Maximum_Product_of_Splitted_Binary_Tree {

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

    long maxProd = 0;

    public int maxProduct(TreeNode root) {

        int MOD = 1_000_000_007;

        if (root == null) {
            return 0;
        }

        long totalSum = getSum(root);
        findMaxProduct(root, totalSum);

        return (int) (maxProd % MOD);

    }

    private long getSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        long leftSum = getSum(root.left);
        long rightSum = getSum(root.right);

        return root.val + leftSum + rightSum;
    }

    private long findMaxProduct(TreeNode root, long totalSum) {

        if (root == null) {
            return 0;
        }

        long leftSum = findMaxProduct(root.left, totalSum);
        long rightSum = findMaxProduct(root.right, totalSum);

        long subTreeSum = root.val + leftSum + rightSum;
        long remSum = totalSum - subTreeSum;

        maxProd = Math.max(maxProd, subTreeSum * remSum);

        return subTreeSum;
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/find-duplicate-subtrees/
 *
 * Given the root of a binary tree, return all duplicate subtrees.
 *
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 *
 * Two trees are duplicate if they have the same structure with the same node values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,null,2,4,null,null,4]
 * Output: [[2,4],[4]]
 * Example 2:
 *
 *
 * Input: root = [2,1,1]
 * Output: [[1]]
 * Example 3:
 *
 *
 * Input: root = [2,2,2,3,null,3,null]
 * Output: [[2,3],[3]]
 *
 *
 * Constraints:
 *
 * The number of the nodes in the tree will be in the range [1, 5000]
 * -200 <= Node.val <= 200
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _652_Find_Duplicate_Subtrees {

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

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        Map<String, Integer> map = new HashMap();

        List<TreeNode> result = new ArrayList<>();

        findSubtreeString(root, map, result);

        return result;
    }

    private String findSubtreeString(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
        if (root == null) {
            return "N";
        }

        String str = String.valueOf(root.val) + "," + findSubtreeString(root.left, map, result) + ","
                + findSubtreeString(root.right, map, result);

        if (map.getOrDefault(str, 0) == 1) {
            result.add(root);
        }

        map.put(str, map.getOrDefault(str, 0) + 1);
        return str;
    }
}

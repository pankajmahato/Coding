/**********************************************************************************
 *
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
 *
 * You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.
 *
 * Each minute, a node becomes infected if:
 *
 * The node is currently uninfected.
 * The node is adjacent to an infected node.
 * Return the number of minutes needed for the entire tree to be infected.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,5,3,null,4,10,6,9,2], start = 3
 * Output: 4
 * Explanation: The following nodes are infected during:
 * - Minute 0: Node 3
 * - Minute 1: Nodes 1, 10 and 6
 * - Minute 2: Node 5
 * - Minute 3: Node 4
 * - Minute 4: Nodes 9 and 2
 * It takes 4 minutes for the whole tree to be infected so we return 4.
 * Example 2:
 *
 *
 * Input: root = [1], start = 1
 * Output: 0
 * Explanation: At minute 0, the only node in the tree is infected so we return 0.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 105].
 * 1 <= Node.val <= 105
 * Each node has a unique value.
 * A node with a value of start exists in the tree.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _2385_Amount_of_Time_for_Binary_Tree_to_Be_Infected {


    static class TreeNode {
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
    
    public int amountOfTime(TreeNode root, int start) {

        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        generateAdjMap(root, -1, adjMap);

        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        int minute = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {

                int u = queue.remove();
                for (int v : adjMap.get(u)) {

                    if (!visited.contains(v)) {

                        visited.add(v);
                        queue.add(v);
                    }
                }
            }
            minute++;
        }

        return minute - 1;
    }

    private void generateAdjMap(TreeNode root, int parent, Map<Integer, List<Integer>> adjMap) {

        if (root == null) {
            return;
        }

        int curr = root.val;
        if (!adjMap.containsKey(curr)) {
            adjMap.put(curr, new ArrayList<>());
        }

        if (parent != -1) {
            adjMap.get(curr).add(parent);
        }

        if (root.left != null) {
            adjMap.get(curr).add(root.left.val);
        }

        if (root.right != null) {
            adjMap.get(curr).add(root.right.val);
        }

        generateAdjMap(root.left, root.val, adjMap);
        generateAdjMap(root.right, root.val, adjMap);
    }
}

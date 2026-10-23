/**********************************************************************************
 *
 * https://leetcode.com/problems/validate-binary-tree-nodes/
 *
 * You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.
 *
 * If node i has no left child then leftChild[i] will equal -1, similarly for the right child.
 *
 * Note that the nodes have no values and that we only use the node numbers in this problem.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
 * Output: true
 * Example 2:
 *
 *
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
 * Output: false
 * Example 3:
 *
 *
 * Input: n = 2, leftChild = [1,0], rightChild = [-1,-1]
 * Output: false
 *
 *
 * Constraints:
 *
 * n == leftChild.length == rightChild.length
 * 1 <= n <= 104
 * -1 <= leftChild[i], rightChild[i] <= n - 1
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _1361_Validate_Binary_Tree_Nodes {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        // Property of Binary Tree
        // 1. Every child has only 1 parent
        // 2. There is only 1 root (node without parent)
        // 3. It has only 1 component

        Map<Integer, Integer> childToParentMap = new HashMap<>();
        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        // Validate there is only 1 root (node without parent)
        for (int i = 0; i < n; i++) {

            int node = i;
            int left = leftChild[i];
            int right = rightChild[i];

            if (left != -1) {

                adjMap.computeIfAbsent(node, k -> new ArrayList<>()).add(left);

                if (childToParentMap.containsKey(left)) {

                    // Contains more than 1 parent
                    return false;
                }

                childToParentMap.put(left, node);
            }

            if (right != -1) {

                adjMap.computeIfAbsent(node, k -> new ArrayList<>()).add(right);

                if (childToParentMap.containsKey(right)) {

                    // Contains more than 1 parent
                    return false;
                }

                childToParentMap.put(right, node);
            }
        }

        // Find root node

        int root = -1;

        for (int i = 0; i < n; i++) {

            if (!childToParentMap.containsKey(i)) {

                if (root != -1) {

                    // More than 1 root
                    return false;
                }

                root = i;
            }
        }

        // No root present (cycle)
        if (root == -1) {
            return false;
        }

        // Check for 1 component
        int count = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.add(root);
        count++;

        while (!queue.isEmpty()) {

            int u = queue.remove();

            for (int v : adjMap.getOrDefault(u, new ArrayList<>())) {

                if (visited[v] == false) {
                    queue.add(v);
                    count++;
                    visited[v] = true;
                }
            }
        }

        return count == n;
    }
}

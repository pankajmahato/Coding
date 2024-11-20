/**********************************************************************************
 *
 * https://leetcode.com/problems/clone-graph/
 *
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * Test case format:
 *
 * For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
 *
 * An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * Example 2:
 *
 *
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
 * Example 3:
 *
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 *
 *
 * Constraints:
 *
 * The number of nodes in the graph is in the range [0, 100].
 * 1 <= Node.val <= 100
 * Node.val is unique for each node.
 * There are no repeated edges and no self-loops in the graph.
 * The Graph is connected and all nodes can be visited starting from the given node.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _133_Clone_Graph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

//    public Node cloneGraph(Node node) {
//
//        // DFS
//
//        if (node == null) {
//            return null;
//        }
//
//        Map<Node, Node> cloneMap = new HashMap<>();
//
//        Node cloneNode = new Node(node.val, new ArrayList<>());
//
//        cloneMap.put(node, cloneNode);
//
//        dfs(node, cloneNode, cloneMap);
//
//        return cloneNode;
//    }
//
//    private void dfs(Node node, Node cloneNode, Map<Node, Node> cloneMap) {
//
//        for (Node n : node.neighbors) {
//
//            Node clone = cloneMap.get(n);
//            if (clone == null) {
//                clone = new Node(n.val, new ArrayList<>());
//                cloneMap.put(n, clone);
//                cloneNode.neighbors.add(clone);
//                dfs(n, clone, cloneMap);
//            } else {
//                cloneNode.neighbors.add(clone);
//            }
//        }
//    }

    public Node cloneGraph(Node node) {

        // BFS

        if (node == null) {
            return null;
        }

        Map<Node, Node> cloneMap = new HashMap<>();

        Node cloneNode = new Node(node.val, new ArrayList<>());

        cloneMap.put(node, cloneNode);

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        bfs(queue, cloneMap);

        return cloneNode;
    }

    private void bfs(Queue<Node> queue, Map<Node, Node> cloneMap) {

        while (!queue.isEmpty()) {

            Node node = queue.remove();
            Node cloneNode = cloneMap.get(node);

            for (Node n : node.neighbors) {

                Node clone = cloneMap.get(n);
                if (clone == null) {
                    clone = new Node(n.val, new ArrayList<>());
                    cloneMap.put(n, clone);
                    cloneNode.neighbors.add(clone);
                    queue.add(n);
                } else {
                    cloneNode.neighbors.add(clone);
                }
            }
        }
    }
}

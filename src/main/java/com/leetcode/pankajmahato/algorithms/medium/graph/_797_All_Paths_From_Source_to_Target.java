/**********************************************************************************
 *
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 *
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Example 2:
 *
 *
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * Example 3:
 *
 * Input: graph = [[1],[]]
 * Output: [[0,1]]
 * Example 4:
 *
 * Input: graph = [[1,2,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,2,3],[0,3]]
 * Example 5:
 *
 * Input: graph = [[1,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,3]]
 *
 *
 * Constraints:
 *
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * The input graph is guaranteed to be a DAG.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.graph;

import java.util.ArrayList;
import java.util.List;

public class _797_All_Paths_From_Source_to_Target {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> paths = new ArrayList<>();
        _allPathsSourceTarget(graph, 0, graph.length - 1, paths, new ArrayList<Integer>() {
            {
                add(0);
            }
        });

        return paths;

    }

    public void _allPathsSourceTarget(int[][] graph, int src, int dest, List<List<Integer>> paths, List<Integer> currPath) {

        if (src == dest) {
            paths.add(new ArrayList<>(currPath));
            return;
        }

        for (int child : graph[src]) {
            currPath.add(child);
            _allPathsSourceTarget(graph, child, graph.length - 1, paths, currPath);
            currPath.remove(currPath.size() - 1);
        }

    }
}

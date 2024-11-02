/**********************************************************************************
 *
 * https://leetcode.com/problems/course-schedule/
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _207_Course_Schedule {
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        // BFS
//        Map<Integer, List<Integer>> adj = new HashMap<>();
//        int[] indegree = new int[numCourses];
//        for (int i = 0; i < numCourses; i++) {
//            adj.put(i, new ArrayList<>());
//        }
//        for (int i = 0; i < prerequisites.length; i++) {
//            int u = prerequisites[i][1];
//            int v = prerequisites[i][0];
//            adj.get(u).add(v);
//            indegree[v]++;
//        }
//
//        int count = 0;
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < indegree.length; i++) {
//            if (indegree[i] == 0) {
//                queue.add(i);
//                count++;
//            }
//        }
//
//        while (!queue.isEmpty()) {
//
//            int u = queue.remove();
//
//            for (int v : adj.get(u)) {
//                indegree[v]--;
//                if (indegree[v] == 0) {
//                    queue.add(v);
//                    count++;
//                }
//            }
//        }
//
//        if (count == numCourses) {
//            return true;
//        }
//
//        return false;
//    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // DFS
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && isCycleDFS(adj, i, inRecursion, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean isCycleDFS(Map<Integer, List<Integer>> adj, int u, boolean[] inRecursion, boolean[] visited) {

        visited[u] = true;
        inRecursion[u] = true;

        for (int v : adj.get(u)) {
            if (visited[v] == false && isCycleDFS(adj, v, inRecursion, visited)) {
                return true;
            } else if (inRecursion[v] == true) {
                return true;
            }
        }

        inRecursion[u] = false;
        return false;
    }

}

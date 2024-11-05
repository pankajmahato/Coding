/**********************************************************************************
 *
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class _210_Course_Schedule_II {
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//
//        Map<Integer, List<Integer>> adj = new HashMap<>();
//        int[] indegree = new int[numCourses];
//
//        for (int i = 0; i < numCourses; i++) {
//            adj.put(i, new ArrayList<>());
//        }
//        for (int i = 0; i < prerequisites.length; i++) {
//            int u = prerequisites[i][1];
//            int v = prerequisites[i][0];
//
//            adj.get(u).add(v);
//            indegree[v]++;
//        }
//
//        int count = 0;
//        int[] result = new int[numCourses];
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (indegree[i] == 0) {
//                queue.add(i);
//                result[count] = i;
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
//                    result[count] = v;
//                    count++;
//                }
//            }
//        }
//
//        if (count == numCourses) {
//            return result;
//        }
//        return new int[0];
//    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];

            adj.get(u).add(v);
        }

        int[] result = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == false && DFS(adj, i, visited, inRecursion, stack)) {
                return new int[0];
            }
        }

        int idx = 0;
        while (!stack.isEmpty()) {
            result[idx++] = stack.pop();
        }
        return result;
    }

    private boolean DFS(Map<Integer, List<Integer>> adj, int u, boolean[] visited, boolean[] inRecursion,
            Stack<Integer> stack) {

        visited[u] = true;
        inRecursion[u] = true;
        for (int v : adj.get(u)) {
            if (visited[v] == false && DFS(adj, v, visited, inRecursion, stack)) {
                return true;
            } else if (inRecursion[v] == true) {
                return true;
            }
        }

        inRecursion[u] = false;
        stack.push(u);
        return false;
    }

}

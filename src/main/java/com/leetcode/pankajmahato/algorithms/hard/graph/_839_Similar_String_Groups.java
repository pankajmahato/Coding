/**********************************************************************************
 *
 * https://leetcode.com/problems/similar-string-groups/
 *
 * Two strings, X and Y, are considered similar if either they are identical or we can make them equivalent by swapping at most two letters (in distinct positions) within the string X.
 *
 * For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".
 *
 * Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.
 *
 * We are given a list strs of strings where every string in strs is an anagram of every other string in strs. How many groups are there?
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["tars","rats","arts","star"]
 * Output: 2
 * Example 2:
 *
 * Input: strs = ["omv","ovm"]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 300
 * 1 <= strs[i].length <= 300
 * strs[i] consists of lowercase letters only.
 * All words in strs have the same length and are anagrams of each other.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _839_Similar_String_Groups {

//    public int numSimilarGroups(String[] strs) {
//
//        int n = strs.length;
//
//        Map<Integer, List<Integer>> adj = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            adj.put(i, new ArrayList<>());
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//
//                if (isSimilar(strs[i], strs[j])) {
//                    adj.get(i).add(j);
//                    adj.get(j).add(i);
//                }
//            }
//        }
//
//        boolean[] visited = new boolean[n];
//
//        int groups = 0;
//
//        for (int i = 0; i < n; i++) {
//            if (visited[i] == false) {
//                dfs(adj, i, visited);
//                groups++;
//            }
//        }
//
//        return groups;
//    }
//
//    private void dfs(Map<Integer, List<Integer>> adj, int u, boolean[] visited) {
//
//        visited[u] = true;
//
//        for (int v : adj.get(u)) {
//            if (visited[v] == false) {
//                dfs(adj, v, visited);
//            }
//        }
//    }

    public int numSimilarGroups(String[] strs) {

        int n = strs.length;

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (isSimilar(strs[i], strs[j])) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];

        int groups = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                bfs(adj, i, visited);
                groups++;
            }
        }

        return groups;
    }

    private void bfs(Map<Integer, List<Integer>> adj, int node, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {

            int u = queue.remove();
            for (int v : adj.get(u)) {
                if (visited[v] == false) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    private boolean isSimilar(String s1, String s2) {

        int diff = 0;
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }

        return diff <= 2;
    }

}

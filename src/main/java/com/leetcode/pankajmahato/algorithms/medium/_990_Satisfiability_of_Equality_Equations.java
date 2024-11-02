/**********************************************************************************
 *
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 *
 * You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.
 *
 * Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
 * There is no way to assign the variables to satisfy both equations.
 * Example 2:
 *
 * Input: equations = ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 *
 *
 * Constraints:
 *
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] is a lowercase letter.
 * equations[i][1] is either '=' or '!'.
 * equations[i][2] is '='.
 * equations[i][3] is a lowercase letter.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;


public class _990_Satisfiability_of_Equality_Equations {

    public boolean equationsPossible(String[] equations) {

        int size = 26;
        int[] parent = new int[size];
        int[] rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (String s : equations) {
            if (s.charAt(1) == '=') {
                union(s.charAt(0) - 'a', s.charAt(3) - 'a', parent, rank);
            }
        }

        for (String s : equations) {
            if (s.charAt(1) == '!') {
                int a = find(s.charAt(0) - 'a', parent);
                int b = find(s.charAt(3) - 'a', parent);

                if (a == b) {
                    return false;
                }
            }
        }

        return true;
    }

    private int find(int i, int[] parent) {
        if (i == parent[i]) {
            return i;
        }

        return parent[i] = find(parent[i], parent);
    }

    private void union(int x, int y, int[] parent, int[] rank) {

        int xParent = find(x, parent);
        int yParent = find(y, parent);

        if (xParent == yParent) {
            return;
        }

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[xParent]++;
        }
    }

}

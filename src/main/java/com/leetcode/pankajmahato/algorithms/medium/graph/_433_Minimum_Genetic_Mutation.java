/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-genetic-mutation/
 *
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 *
 * Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.
 *
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 * There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
 *
 * Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.
 *
 * Note that the starting point is assumed to be valid, so it might not be included in the bank.
 *
 *
 *
 * Example 1:
 *
 * Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
 * Output: 1
 * Example 2:
 *
 * Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 0 <= bank.length <= 10
 * startGene.length == endGene.length == bank[i].length == 8
 * startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.graph;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _433_Minimum_Genetic_Mutation {

    public int minMutation(String startGene, String endGene, String[] bank) {

        if (bank.length == 0) {
            return -1;
        }
        Set<String> visited = new HashSet<>();
        Set<String> bankSet = new HashSet<>();
        char[] gene = new char[]{'A', 'C', 'G', 'T'};

        for (String s : bank) {
            bankSet.add(s);
        }

        int level = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        visited.add(startGene);
        while (!queue.isEmpty()) {

            int n = queue.size();
            while (n-- > 0) {
                String curr = queue.remove();

                if (endGene.equals(curr)) {
                    return level;
                }
                char[] currArray = curr.toCharArray();
                for (int i = 0; i < currArray.length; i++) {
                    char temp = currArray[i];
                    for (char g : gene) {
                        currArray[i] = g;
                        String mutated = new String(currArray);
                        if (visited.contains(mutated) == false && bankSet.contains(mutated) == true) {
                            queue.add(mutated);
                            visited.add(mutated);
                        }
                    }
                    currArray[i] = temp;
                }
            }
            level++;
        }

        return -1;
    }

}

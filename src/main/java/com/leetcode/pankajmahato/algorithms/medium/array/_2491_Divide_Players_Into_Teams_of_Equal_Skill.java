/**********************************************************************************
 *
 * https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/
 *
 * You are given a positive integer array skill of even length n where skill[i] denotes the skill of the ith player. Divide the players into n / 2 teams of size 2 such that the total skill of each team is equal.
 *
 * The chemistry of a team is equal to the product of the skills of the players on that team.
 *
 * Return the sum of the chemistry of all the teams, or return -1 if there is no way to divide the players into teams such that the total skill of each team is equal.
 *
 *
 *
 * Example 1:
 *
 * Input: skill = [3,2,5,1,3,4]
 * Output: 22
 * Explanation: 
 * Divide the players into the following teams: (1, 5), (2, 4), (3, 3), where each team has a total skill of 6.
 * The sum of the chemistry of all the teams is: 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 + 9 = 22.
 * Example 2:
 *
 * Input: skill = [3,4]
 * Output: 12
 * Explanation: 
 * The two players form a team with a total skill of 7.
 * The chemistry of the team is 3 * 4 = 12.
 * Example 3:
 *
 * Input: skill = [1,1,2,3]
 * Output: -1
 * Explanation: 
 * There is no way to divide the players into teams such that the total skill of each team is equal.
 *
 *
 * Constraints:
 *
 * 2 <= skill.length <= 105
 * skill.length is even.
 * 1 <= skill[i] <= 1000
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _2491_Divide_Players_Into_Teams_of_Equal_Skill {

    // public long dividePlayers(int[] skill) {

    //     int n = skill.length;
    //     Arrays.sort(skill);

    //     int i = 0;
    //     int j = n - 1;
    //     long result = 0;
    //     int sum = skill[i] + skill[j];

    //     while (i < j) {

    //         if (skill[i] + skill[j] != sum) {
    //             return -1;
    //         }

    //         result = result + (long) skill[i] * skill[j];
    //         i++;
    //         j--;
    //     }

    //     return result;
    // }

    public long dividePlayers(int[] skill) {
        // Counting sort due to small constraint of ith element
        int n = skill.length;

        int MAX_ELEMENT = 1000;
        int[] freq = new int[MAX_ELEMENT + 1];
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum = totalSum + skill[i];
            freq[skill[i]]++;
        }

        int teams = n / 2;

        // Not possible to divide equally
        if (totalSum % teams != 0) {
            return -1;
        }

        int target = totalSum / teams;

        long result = 0;

        for (int currSkill = 1; currSkill <= MAX_ELEMENT; currSkill++) {

            if (freq[currSkill] == 0) {
                continue;
            }

            int remainSkill = target - currSkill;

            if (remainSkill < 1 || remainSkill > MAX_ELEMENT || freq[currSkill] != freq[remainSkill]) {
                return -1;
            }

            result = result + (long) currSkill * remainSkill * freq[currSkill];
        }

        // Counted twice; (a,b) and (b,a)
        return result / 2;
    }
}

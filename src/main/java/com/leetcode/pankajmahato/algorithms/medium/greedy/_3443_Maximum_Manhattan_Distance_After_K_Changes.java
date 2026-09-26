
/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-manhattan-distance-after-k-changes/
 *
 * You are given a string s consisting of the characters 'N', 'S', 'E', and 'W', where s[i] indicates movements in an infinite grid:
 *
 * 'N' : Move north by 1 unit.
 * 'S' : Move south by 1 unit.
 * 'E' : Move east by 1 unit.
 * 'W' : Move west by 1 unit.
 * Initially, you are at the origin (0, 0). You can change at most k characters to any of the four directions.
 *
 * Find the maximum Manhattan distance from the origin that can be achieved at any time while performing the movements in order.
 *
 * The Manhattan Distance between two cells (xi, yi) and (xj, yj) is |xi - xj| + |yi - yj|.
 *
 *
 * Example 1:
 *
 * Input: s = "NWSE", k = 1
 *
 * Output: 3
 *
 * Explanation:
 *
 * Change s[2] from 'S' to 'N'. The string s becomes "NWNE".
 *
 * Movement	Position (x, y)	Manhattan Distance	Maximum
 * s[0] == 'N'	(0, 1)	0 + 1 = 1	1
 * s[1] == 'W'	(-1, 1)	1 + 1 = 2	2
 * s[2] == 'N'	(-1, 2)	1 + 2 = 3	3
 * s[3] == 'E'	(0, 2)	0 + 2 = 2	3
 * The maximum Manhattan distance from the origin that can be achieved is 3. Hence, 3 is the output.
 *
 * Example 2:
 *
 * Input: s = "NSWWEW", k = 3
 *
 * Output: 6
 *
 * Explanation:
 *
 * Change s[1] from 'S' to 'N', and s[4] from 'E' to 'W'. The string s becomes "NNWWWW".
 *
 * The maximum Manhattan distance from the origin that can be achieved is 6. Hence, 6 is the output.
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * 0 <= k <= s.length
 * s consists of only 'N', 'S', 'E', and 'W'.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.greedy;

public class _3443_Maximum_Manhattan_Distance_After_K_Changes {

    public int maxDistance(String s, int k) {

        // Observation
        // Manhattan distance (MD) = |xi - xj| + |yi - yj|
        // MD from origin (0,0) = |x| + |y|
        // (east and west) or (north and south) cancel each other so effectively
        // MD = |east - west| + |north - south|
        // Any time East is replace by West or North is replaced by South the distance increases by 2

        int north = 0;
        int south = 0;
        int east = 0;
        int west = 0;

        int maxDistance = 0;

        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)) {
                case 'N':
                    north++;
                    break;
                case 'S':
                    south++;
                    break;
                case 'E':
                    east++;
                    break;
                case 'W':
                    west++;
                    break;
            }

            int currentDistance = Math.abs(east - west) + Math.abs(north - south);
            int stepsTillNow = i + 1;

            // Wasted steps are when we get (east and west) or (north and south)
            int stepsWasted = stepsTillNow - currentDistance;

            int extraStepsPossible = Math.min(stepsWasted, 2 * k);

            maxDistance = Math.max(maxDistance, currentDistance + extraStepsPossible);
        }

        return maxDistance;
    }
}

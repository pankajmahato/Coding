/**********************************************************************************
 *
 * https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i/
 *
 * You are given a 2D array points of size n x 2 representing integer coordinates of some points on a 2D plane, where points[i] = [xi, yi].
 *
 * Count the number of pairs of points (A, B), where
 *
 * A is on the upper left side of B, and
 * there are no other points in the rectangle (or line) they make (including the border), except for the points A and B.
 * Return the count.
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,1],[2,2],[3,3]]
 *
 * Output: 0
 *
 * Explanation:
 *
 *
 *
 * There is no way to choose A and B such that A is on the upper left side of B.
 *
 * Example 2:
 *
 * Input: points = [[6,2],[4,4],[2,6]]
 *
 * Output: 2
 *
 * Explanation:
 *
 *
 *
 * The left one is the pair (points[1], points[0]), where points[1] is on the upper left side of points[0] and the rectangle is empty.
 * The middle one is the pair (points[2], points[1]), same as the left one it is a valid pair.
 * The right one is the pair (points[2], points[0]), where points[2] is on the upper left side of points[0], but points[1] is inside the rectangle so it's not a valid pair.
 * Example 3:
 *
 * Input: points = [[3,1],[1,3],[1,1]]
 *
 * Output: 2
 *
 * Explanation:
 *
 *
 *
 * The left one is the pair (points[2], points[0]), where points[2] is on the upper left side of points[0] and there are no other points on the line they form. Note that it is a valid state when the two points form a line.
 * The middle one is the pair (points[1], points[2]), it is a valid pair same as the left one.
 * The right one is the pair (points[1], points[0]), it is not a valid pair as points[2] is on the border of the rectangle.
 *
 *
 * Constraints:
 *
 * 2 <= n <= 50
 * points[i].length == 2
 * 0 <= points[i][0], points[i][1] <= 50
 * All points[i] are distinct.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.Arrays;

public class _3025_Find_the_Number_of_Ways_to_Place_People_I {

    public int numberOfPairs(int[][] points) {

        int n = points.length;

        // Sorting by x asc and y descending makes A on upper left of B
        Arrays.sort(points, (a, b) -> {
            int val = Integer.compare(a[0], b[0]);
            if (val == 0) {
                return Integer.compare(b[1], a[1]);
            }

            return val;
        });

        int result = 0;

        for (int i = 0; i < n; i++) {

            // A (x1,y1)
            int x1 = points[i][0];
            int y1 = points[i][1];

            // Find the max y between i and j. If found then j is invalid i.e. there is a point in the rectangle
            int maxY = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {

                // B (x2,y2)
                int x2 = points[j][0];
                int y2 = points[j][1];

                // B is above A
                if (y2 > y1) {
                    continue;
                }

                // No point between A and B rectangle
                if (y2 > maxY) {
                    result++;
                    maxY = y2;
                }
            }
        }

        return result;
    }
}

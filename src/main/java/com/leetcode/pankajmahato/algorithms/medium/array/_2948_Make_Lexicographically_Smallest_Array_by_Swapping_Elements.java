/**********************************************************************************
 *
 * https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/
 *
 * You are given a 0-indexed array of positive integers nums and a positive integer limit.
 *
 * In one operation, you can choose any two indices i and j and swap nums[i] and nums[j] if |nums[i] - nums[j]| <= limit.
 *
 * Return the lexicographically smallest array that can be obtained by performing the operation any number of times.
 *
 * An array a is lexicographically smaller than an array b if in the first position where a and b differ, array a has an element that is less than the corresponding element in b. For example, the array [2,10,3] is lexicographically smaller than the array [10,2,3] because they differ at index 0 and 2 < 10.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,3,9,8], limit = 2
 * Output: [1,3,5,8,9]
 * Explanation: Apply the operation 2 times:
 * - Swap nums[1] with nums[2]. The array becomes [1,3,5,9,8]
 * - Swap nums[3] with nums[4]. The array becomes [1,3,5,8,9]
 * We cannot obtain a lexicographically smaller array by applying any more operations.
 * Note that it may be possible to get the same result by doing different operations.
 * Example 2:
 *
 * Input: nums = [1,7,6,18,2,1], limit = 3
 * Output: [1,6,7,18,1,2]
 * Explanation: Apply the operation 3 times:
 * - Swap nums[1] with nums[2]. The array becomes [1,6,7,18,2,1]
 * - Swap nums[0] with nums[4]. The array becomes [2,6,7,18,1,1]
 * - Swap nums[0] with nums[5]. The array becomes [1,6,7,18,1,2]
 * We cannot obtain a lexicographically smaller array by applying any more operations.
 * Example 3:
 *
 * Input: nums = [1,7,28,19,10], limit = 3
 * Output: [1,7,28,19,10]
 * Explanation: [1,7,28,19,10] is the lexicographically smallest array we can obtain because we cannot apply the operation on any two indices.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= limit <= 109
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2948_Make_Lexicographically_Smallest_Array_by_Swapping_Elements {

    static class Pair {

        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        // Copy the nums and sort it based on its value
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(nums[i], i));
        }
        pairs.sort((a, b) -> Integer.compare(a.val, b.val));

        // Create list of groups of numbers for the limit
        List<List<Pair>> groups = new ArrayList<>();

        // Add the first number(pair) to the first group
        groups.add(new ArrayList<>(Arrays.asList(pairs.get(0))));

        // Assign rest of the numbers to their respective groups, create new group if condition doesn't match
        for (int i = 1; i < n; i++) {
            int y = pairs.get(i).val;
            int x = pairs.get(i - 1).val;

            if (y - x <= limit) {
                groups.get(groups.size() - 1).add(pairs.get(i));
            } else {
                groups.add(new ArrayList<>(Arrays.asList(pairs.get(i))));
            }
        }

        int[] result = new int[n];

        for (List<Pair> group : groups) {

            // Sort by index to preserve the orginal order
            List<Pair> sortedGroup = new ArrayList<>(group);
            sortedGroup.sort((a, b) -> Integer.compare(a.idx, b.idx));

            // Store the sorted group at the original index
            for (int i = 0; i < group.size(); i++) {
                result[sortedGroup.get(i).idx] = group.get(i).val;
            }
        }

        return result;
    }
}

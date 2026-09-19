/**********************************************************************************
 *
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/
 *
 * Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a list of disjoint intervals.
 *
 * Implement the SummaryRanges class:
 *
 * SummaryRanges() Initializes the object with an empty stream.
 * void addNum(int value) Adds the integer value to the stream.
 * int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint intervals [starti, endi]. The answer should be sorted by starti.
 *
 *
 * Example 1:
 *
 * Input
 * ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
 * [[], [1], [], [3], [], [7], [], [2], [], [6], []]
 * Output
 * [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
 *
 * Explanation
 * SummaryRanges summaryRanges = new SummaryRanges();
 * summaryRanges.addNum(1);      // arr = [1]
 * summaryRanges.getIntervals(); // return [[1, 1]]
 * summaryRanges.addNum(3);      // arr = [1, 3]
 * summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
 * summaryRanges.addNum(7);      // arr = [1, 3, 7]
 * summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
 * summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
 * summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
 * summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
 * summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
 *
 *
 * Constraints:
 *
 * 0 <= value <= 104
 * At most 3 * 104 calls will be made to addNum and getIntervals.
 * At most 102 calls will be made to getIntervals.
 *
 *
 * Follow up: What if there are lots of merges and the number of disjoint intervals is small compared to the size of the data stream?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class _352_Data_Stream_as_Disjoint_Intervals {

    TreeMap<Integer, int[]> map;

    public _352_Data_Stream_as_Disjoint_Intervals() {
        map = new TreeMap<>();
    }

    public void addNum(int value) {

        if (map.containsKey(value)) {
            return;
        }

        int left = value;
        int right = value;

        Integer lower = map.lowerKey(value);
        Integer higher = map.higherKey(value);

        if (lower != null) {

            if (map.get(lower)[1] >= value) {
                return;
            }

            if (map.get(lower)[1] == value - 1) {
                left = map.get(lower)[0];
            }

        }

        if (higher != null && map.get(higher)[0] == value + 1) {
            right = map.get(higher)[1];
            map.remove(higher);
        }

        map.put(left, new int[]{left, right});
    }

    public int[][] getIntervals() {
        List<int[]> intervals = new ArrayList<>(map.values());
        return intervals.toArray(new int[intervals.size()][]);
    }
}

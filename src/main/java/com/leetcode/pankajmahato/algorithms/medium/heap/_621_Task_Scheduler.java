/**********************************************************************************
 *
 * https://leetcode.com/problems/task-scheduler/
 *
 * You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.
 *
 * Return the minimum number of CPU intervals required to complete all tasks.
 *
 *
 *
 * Example 1:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 *
 * Output: 8
 *
 * Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 * After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.
 *
 * Example 2:
 *
 * Input: tasks = ["A","C","A","B","D","B"], n = 1
 *
 * Output: 6
 *
 * Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
 *
 * With a cooling interval of 1, you can repeat a task after just one other task.
 *
 * Example 3:
 *
 * Input: tasks = ["A","A","A", "B","B","B"], n = 3
 *
 * Output: 10
 *
 * Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.
 *
 * There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.
 *
 *
 *
 * Constraints:
 *
 * 1 <= tasks.length <= 104
 * tasks[i] is an uppercase English letter.
 * 0 <= n <= 100
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.heap;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _621_Task_Scheduler {

    class Pair {

        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int result = 0;

        while (!queue.isEmpty()) {

            List<Pair> temp = new ArrayList<>();
            for (int i = 1; i <= n + 1; i++) {

                if (!queue.isEmpty()) {

                    Pair p = queue.remove();
                    p.freq--;
                    temp.add(p);
                }
            }

            for (Pair p : temp) {
                if (p.freq > 0) {
                    queue.add(p);
                }
            }

            if (queue.isEmpty()) {
                result += temp.size();
            } else {
                result += n + 1;
            }
        }

        return result;
    }
}

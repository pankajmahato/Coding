/**********************************************************************************
 *
 * https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 *
 * Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
 *
 * After doing so, return the head of the final linked list.  You may return any such answer.
 *
 *
 *
 * (Note that in the examples below, all sequences are serializations of ListNode objects.)
 *
 * Example 1:
 *
 * Input: head = [1,2,-3,3,1]
 * Output: [3,1]
 * Note: The answer [1,2,1] would also be accepted.
 * Example 2:
 *
 * Input: head = [1,2,3,-3,4]
 * Output: [1,2,4]
 * Example 3:
 *
 * Input: head = [1,2,3,-3,-2]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The given linked list will contain between 1 and 1000 nodes.
 * Each node in the linked list has -1000 <= node.val <= 1000.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

public class _1171_Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List {
    public ListNode removeZeroSumSublists(ListNode head) {

        ListNode dummy = new ListNode(0, head);
        Map<Integer, ListNode> prefixMap = new HashMap<>();

        int prefixSum = 0;
        prefixMap.put(prefixSum, dummy);

        while (head != null) {
            prefixSum = prefixSum + head.val;

            if (!prefixMap.containsKey(prefixSum)) {
                prefixMap.put(prefixSum, head);
            } else {
                int pSum = prefixSum;
                ListNode start = prefixMap.get(pSum);
                ListNode temp = start;

                while (temp != head) {
                    temp = temp.next;
                    pSum = pSum + temp.val;
                    if (temp != head) {
                        prefixMap.remove(pSum);
                    }
                }
                start.next = head.next;
            }
            head = head.next;
        }

        return dummy.next;

    }
}

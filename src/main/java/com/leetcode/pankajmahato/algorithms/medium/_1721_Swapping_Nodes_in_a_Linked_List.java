/**********************************************************************************
 *
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 *
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;

public class _1721_Swapping_Nodes_in_a_Linked_List {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapNodes(ListNode head, int k) {

        ListNode node1 = null;
        ListNode node2 = head;

        ListNode temp = head;

        while (temp != null && k != 1) {
            temp = temp.next;
            k--;
        }
        node1 = temp;
        temp = temp.next;

        while (temp != null) {
            temp = temp.next;
            node2 = node2.next;
        }

        int val = node1.val;
        node1.val = node2.val;
        node2.val = val;

        return head;
    }
}

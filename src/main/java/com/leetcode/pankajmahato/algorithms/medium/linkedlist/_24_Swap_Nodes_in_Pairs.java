/**********************************************************************************
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 *
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4]
 *
 * Output: [2,1,4,3]
 *
 * Explanation:
 *
 *
 *
 * Example 2:
 *
 * Input: head = []
 *
 * Output: []
 *
 * Example 3:
 *
 * Input: head = [1]
 *
 * Output: [1]
 *
 * Example 4:
 *
 * Input: head = [1,2,3]
 *
 * Output: [2,1,3]
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.linkedlist;


public class _24_Swap_Nodes_in_Pairs {
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

//    public ListNode swapPairs(ListNode head) {
//
//        ListNode dummy = new ListNode(-1, head);
//        ListNode prev = dummy;
//        ListNode curr = head;
//
//        while (curr != null && curr.next != null) {
//
//            prev.next = curr.next;
//            curr.next = prev.next.next;
//            prev.next.next = curr;
//
//            prev = curr;
//            curr = curr.next;
//        }
//
//        return dummy.next;
//    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head.next;
        head.next = swapPairs(head.next.next);
        temp.next = head;

        return temp;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node = new _24_Swap_Nodes_in_Pairs().swapPairs(head);
        System.out.println();
    }

}

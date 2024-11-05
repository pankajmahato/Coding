/**********************************************************************************
 *
 * https://leetcode.com/problems/partition-list/
 *
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * Example 2:
 *
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 200].
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.linkedlist;


public class _86_Partition_List {
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

    public ListNode partition(ListNode head, int x) {

        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);

        ListNode smallP = small;
        ListNode largeP = large;

        while (head != null) {
            if (head.val < x) {
                smallP.next = head;
                smallP = smallP.next;
            } else {
                largeP.next = head;
                largeP = largeP.next;
            }
            head = head.next;
        }

        largeP.next = null;
        smallP.next = large.next;

        return small.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        new _86_Partition_List().partition(head, 3);
        System.out.println();
    }

}

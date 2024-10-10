/**********************************************************************************
 *
 * https://leetcode.com/problems/split-linked-list-in-parts/
 *
 * Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
 *
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.
 *
 * The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.
 *
 * Return an array of the k parts.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but its string representation as a ListNode is [].
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * Output: [[1,2,3,4],[5,6,7],[8,9,10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 1000].
 * 0 <= Node.val <= 1000
 * 1 <= k <= 50
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;


public class _725_Split_Linked_List_in_Parts {
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

    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode[] result = new ListNode[k];
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        int bucketSize = size / k == 0 ? 1 : size / k;
        int extraNodes = size / k == 0 ? 0 : size % k;

        curr = head;
        for (int i = 0; i < k; i++) {
            ListNode temp = curr;
            int currBucket = bucketSize;
            while (currBucket > 1) {
                temp = temp.next;
                currBucket--;
            }
            if (extraNodes > 0) {
                temp = temp.next;
                extraNodes--;
            }


            result[i] = curr;

            if (curr != null && temp != null) {
                curr = temp.next;
                temp.next = null;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        new _725_Split_Linked_List_in_Parts().splitListToParts(head, 3);
        System.out.println();
    }

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// TC = O(n), SC - O(1)
class Solution {
    public void reorderList(ListNode head) {
        // to get to the middle of the list
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next; // slow pointing to last node of first half
        slow.next = null;

        // reverse the second half
        ListNode next = null, prev = null, temp2 = secondHead;

        while(secondHead != null) {
            next = secondHead.next;
            secondHead.next = prev;
            prev = secondHead;
            secondHead = next;
        }
        

        ListNode temp1 = null, firstHead = head;
        temp2 = null;// 1 -> 2 4 -> 3
        secondHead = prev;

        while(secondHead != null) {
            temp1 = firstHead.next;
            temp2 = secondHead.next;

            firstHead.next = secondHead;
            secondHead.next = temp1;

            firstHead = temp1;
            secondHead = temp2;
        }

    }
}
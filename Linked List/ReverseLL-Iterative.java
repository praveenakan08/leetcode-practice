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
 // TC - O(n), SC - O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head, prev = null, next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev; // as prev pointing to the last node
        return head;
    }
}
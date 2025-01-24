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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, dummy = new ListNode(), slow = dummy;
        slow.next = head;

        int count = 0;

        while(count != n) {
            fast = fast.next;
            count++;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
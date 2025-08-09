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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0, length = 0;

        ListNode temp = head;
        while(temp != null) {
            length++;
            temp = temp.next;
        }

        if(length == 1 && n == 1) {
            return null;
        }

        // l = 5, n = 2 -- run till count == 3
        ListNode slow = null, fast = head;
        while(count != length - n) {
            count++;

            slow = fast;
            fast = fast.next;
        } 

        if(count == 0) {
            return fast.next;
        }
        
        slow.next = fast.next;
        return head;
    }
}
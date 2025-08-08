public /**
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
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }

        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;
        
        ListNode current = secondHead, next = null, prev = null;
        // reverse second half of list

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        secondHead = prev;
        ListNode firstHead = head, temp1 = null, temp2 = null;

        while(secondHead != null) {
            temp1 = firstHead.next;
            temp2 = secondHead.next;

            firstHead.next = secondHead;
            secondHead.next = temp1;

            firstHead = temp1;
            secondHead = temp2;
        }
    }
}{

}

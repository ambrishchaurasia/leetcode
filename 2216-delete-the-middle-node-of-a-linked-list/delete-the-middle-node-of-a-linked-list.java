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
    public ListNode deleteMiddle(ListNode head) {
        ListNode t=head;
        ListNode h=head;
        if(head.next==null)
        return null;
        while( h.next.next!=null && h.next.next.next!=null)
        {
            t=t.next;
            h=h.next.next;

        }
        t.next=t.next.next;
        return head;
    }
}
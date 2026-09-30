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
    public ListNode removeNthFromEnd(ListNode headd, int n) {
        ListNode h=headd;
        int size=0;
        
        while(h!=null)
        {
        h=h.next;
        size++;
        }
        if(size==n)
        return headd.next;
        ListNode head=headd;
        int tr=size-n;
        int cnt=0;
        while(head!=null)
        {
             cnt++;

            if(cnt==tr)
            {
                head.next=head.next.next;
            }
            else
            head=head.next;

        }
        return headd;

    }
}
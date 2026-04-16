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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1=l1;
        ListNode h2=l2;
        ListNode ans=new ListNode();
        ListNode h3=ans;

        int carry=0;
        while(h1!=null || h2!=null)
        {
            int h1val=h1!=null?h1.val:0;
            int h2val=h2!=null?h2.val:0;

            int sum=h1val+h2val;
            sum+=carry;

            if(sum>=10)
            {
            ListNode temp=new ListNode(sum-10);
            h3.next=temp;
            h3=temp;
            }

            else
            {
            ListNode temp=new ListNode(sum);
            h3.next=temp;
            h3=temp;
            }
           
            
            carry=sum-10<0?0:1;

            if(h1!=null)
            h1=h1.next;
            if(h2!=null)    
            h2=h2.next;
            }
            
        if(carry==1)
        {
            ListNode t=new ListNode(1);
            h3.next=t;
            h3=t;
        }

        return ans.next;
        
    }
}
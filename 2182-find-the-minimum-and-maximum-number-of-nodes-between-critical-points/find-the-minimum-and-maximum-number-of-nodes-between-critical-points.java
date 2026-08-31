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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode p=head;
        ListNode c=head.next;
        ListNode n=head.next.next;
        int min=Integer.MAX_VALUE;
        if(head.next==null || head.next.next==null)
        return new int[]{-1,-1};
        int cur=2;
        List<Integer> ans=new ArrayList<>();
        while(n!=null)
        {
            if(c.val>p.val && c.val>n.val)
            {
               ans.add(cur);
            }
            if(c.val<p.val && c.val<n.val)
            {
                ans.add(cur);
            }
            p=p.next;
            c=c.next;
            n=n.next;
            cur++;
        }
        
        for(int i=0;i<ans.size()-1;i++)
        {
            if(ans.get(i+1)-ans.get(i)<min)
            min=ans.get(i+1)-ans.get(i);
        }
        if(ans.size()>1)
        return new int[]{min,ans.get(ans.size()-1)-ans.get(0)};
        else
                return new int[]{-1,-1};


    }
}
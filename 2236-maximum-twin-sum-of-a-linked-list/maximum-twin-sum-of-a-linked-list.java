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
    public int pairSum(ListNode head) {
        ListNode t=head;
        List<Integer> arr=new ArrayList<>();
        while(t!=null)
        {
            arr.add(t.val);
            t=t.next;
        }
        int l=0;
        int r=arr.size()-1;
        int s=0;
        int max=Integer.MIN_VALUE;
        while(l<r)
        {
            s+=arr.get(l)+arr.get(r);
            l++;
            r--;
            if(s>max)
            max=s;
            s=0;
        }
        return max;
        
    }
}
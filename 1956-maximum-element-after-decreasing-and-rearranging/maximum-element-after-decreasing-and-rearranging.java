class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int fre[]=new int[arr.length+1];
        for(int i:arr)
        {
            int idx=Math.min(arr.length,i);
            fre[idx]++;
        }
        int res=1;
        for(int i=2;i<=arr.length;i++)
        {
           res=Math.min(res+fre[i],i);
        }
        return res;
    }
}
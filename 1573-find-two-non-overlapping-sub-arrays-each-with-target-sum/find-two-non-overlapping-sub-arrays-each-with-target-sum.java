class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int l=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        int best[]=new int[arr.length];
        Arrays.fill(best,Integer.MAX_VALUE);
        for(int r=0;r<arr.length;r++)
        {
            sum=sum+arr[r];
            while(sum>target)
            {
                sum=sum-arr[l];
                l++;   
            }
            if(r>0)
            best[r]=best[r-1];
            if(sum==target)
            {
                if(l>0 && best[l-1]!=Integer.MAX_VALUE)
                {
                int cur=best[l-1]+r-l+1;
                if(cur<ans)
                ans=cur;
                }
                best[r]=Math.min(best[r],r-l+1);
            }
    } 
        return (ans==Integer.MAX_VALUE)?-1:ans;
    }
}
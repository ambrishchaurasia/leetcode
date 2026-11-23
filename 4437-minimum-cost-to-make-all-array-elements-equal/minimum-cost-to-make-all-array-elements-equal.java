class Solution {
    public long minCost(int[] nums) {
        long ans=Long.MAX_VALUE;
        int pl=0;
        int pr=0;
        
        for(int i=1;i<nums.length-1;i++)
        {
            //front 
            int l=i;
            int r=i;
            if(i!=1 && nums[i]==nums[i-1])
            {
                l=pl;
            }
            else
            {
                 while(r<nums.length-1 && nums[r]==nums[r+1])
                  r++;
            }
            if(l!=1 && nums[i]==nums[i-1])
            {
                l=pr;
            }
            else
            {
                 while(l>0 && nums[l] == nums[l-1])
                 l--;
            }

            long total=nums.length-(r-l+1);
            long cost=nums[i]*total;
            if(cost<0)
            cost=Long.MAX_VALUE;
            if(cost<ans)
            ans=cost;

            pl=l;
            pr=r;
        }
        return ans;
    }
}
class Solution {
    int dp[];
    public boolean canJump(int[] nums) {
        dp=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            dp[i]=-1;
        }
        return rec(nums,0);  
    }
    boolean rec(int[]nums,int idx)
    {
        if(dp[idx]!=-1)
        return dp[idx]==1?true:false;
        if(idx==nums.length-1)
        return true;

        boolean ans=false;

        for(int i=1;i<=nums[idx];i++)
        {
            if(idx+i>=nums.length)
            {
            dp[idx]=1;
            return true;
            }
            if(idx+i<nums.length)
            ans=ans|rec(nums,idx+i);
        }
        if(ans==true)
        {
            dp[idx]=1;
            return true;
        }
        else
        {
            dp[idx]=0;
            return false;
        }
    }
}
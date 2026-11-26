class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
         dp=new int[nums.length+1][nums.length+1];
        for(int i=0;i<nums.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        int ans=rec(0,-1,nums);
        return ans;
    }
    int rec(int idx,int pre,int []nums)
    {
        if(idx==nums.length)
        return 0;

        if(dp[idx][pre+1]!=-1)
        return dp[idx][pre+1];

        //skip curr
        int len=rec(idx+1,pre,nums);

        //take curr
        if(pre==-1 || nums[idx]>nums[pre])
        {
            len=Math.max(len,1+rec(idx+1,idx,nums));
        }
        return dp[idx][pre+1]=len;
    }
}
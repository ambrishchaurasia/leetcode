class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
         dp=new int[nums.length+1][nums.length+1];
         for(int i=0;i<nums.length+1;i++)
         {
            Arrays.fill(dp[i],1);
         }
         for(int idx= nums.length-1;idx>=0;idx--)
         {
            for(int pre=idx-1;pre>=-1;pre--)
            {
                //not take
                int len=dp[idx+1][pre+1];

                if(pre==-1 || nums[idx]>nums[pre])
                {
                    len=Math.max(len,1+dp[idx+1][idx+1]);
                }
                dp[idx][pre+1]=len;

            }
         }
        return dp[0][0]-1;
    }
}
class Solution {
    int dp[];
    public int lengthOfLIS(int[] nums) {
        int ans=0;
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        for(int i=0;i<nums.length;i++)
        {
          int curr=1+ findLis(nums,i);
          if(ans<curr)
          ans=curr;
        }
        return ans;
    }
    //what recursion menas: length of lis starting from index 'curr' ,whose previous index is 'prev'
    int findLis(int []nums,int curr)
    {

        if(dp[curr]!=-1)
        return dp[curr];

         if(curr==nums.length)
        return 0;

        int ans=0;
        for(int i=curr+1;i<nums.length;i++)
        {
            if(nums[i]<nums[curr])
            continue;

            if(nums[i]>nums[curr])
            {
                int cur= 1+findLis(nums,i);
                if(cur>ans)
                ans=cur;
            }
            }
            return dp[curr]=ans;
    }
}
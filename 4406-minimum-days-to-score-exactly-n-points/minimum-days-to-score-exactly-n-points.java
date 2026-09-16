class Solution {
    public int minDays(int n) {
        int dp[][]=new int[n+1][460];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<460;j++)
            {
                dp[i][j]=-1;
            }
        }

        return helper(0,1,n,dp);
    }
    int helper(int sum,int streak,int target,int dp[][])
    {
        if(sum>target)
        return Integer.MAX_VALUE;

        if(sum==target)
        return 0;

        if(dp[sum][streak]!=-1)
        return dp[sum][streak];

        //take
        int p=helper(sum+streak,streak+1,target,dp);
        if(p!=Integer.MAX_VALUE)
        p=1+p;
        //not take
        int q=Integer.MAX_VALUE;
        if(streak!=1)
        {
         q=helper(sum,1,target,dp);
         if(q!=Integer.MAX_VALUE)
         q=q+1;
        }

        return dp[sum][streak]=Math.min(p,q);
    }
}
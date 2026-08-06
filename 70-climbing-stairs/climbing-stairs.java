class Solution {
    int dp[];
    public int climbStairs(int n) {
     dp=new int[47];
       
        Arrays.fill(dp,-1);
         dp[0]=1;
        dp[1]=1;

        if(dp[n]!=-1)
        return dp[n];

        int left=0;
        int right=0;

        if(dp[n-1]==-1)
        dp[n-1]=climbStairs(n-1);

        if(dp[n-2]==-1)
        dp[n-2]=climbStairs(n-2);

        return dp[n]=dp[n-1]+dp[n-2];
    }
}
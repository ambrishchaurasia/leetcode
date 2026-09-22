class Solution {
    int dp[]=new int[46];
    public int climbStairs(int n) {
            Arrays.fill(dp,-1);

        return rec(n);
    }
    int rec(int n)
    {
        if(n<0)
        return 0;
        if(n==0)
        return 1;
        if(dp[n]!=-1)
        return dp[n];

        int a=rec(n-1);
        int b=rec(n-2);
        return dp[n]=a+b;
    }
}
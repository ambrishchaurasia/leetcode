class Solution {
    int dp[][];
    public int maxCoins(int[] num) {

        
        dp=new int[num.length+1][num.length+1];

        for(int i=0;i<=num.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        
        int n=num.length;
        int []nums=new int [n+2];

        nums[0]=1;
        nums[nums.length-1]=1;
        int j=0;
        for(int i=1;i<nums.length-1;i++)
        {
            nums[i]=num[j];
            j++;
        }
        return helper( nums,1,nums.length-2,dp);
    }

    int helper(int []nums,int i,int j,int dp[][])
    {
        if(i>j)
        return 0;

        if(dp[i][j]!=-1)
        return dp[i][j];
    
        int max=Integer.MIN_VALUE;

         for(int k=i;k<=j;k++)
            {
                int cur=helper(nums,i,k-1,dp)+helper(nums,k+1,j,dp)+nums[i-1]*nums[k]*nums[j+1];
                if(cur>max)
                max=cur;
            }
            return dp[i][j]= max;
    }
}
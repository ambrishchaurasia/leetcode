class Solution {
        long dp[][][];
    public long maxAlternatingSum(int[] nums) {
        dp=new long[nums.length][2][2];
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<2;j++)
            {
                Arrays.fill(dp[i][j],Integer.MIN_VALUE);
            }
        }
        long ans=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
        long cur= nums[i]+rec(nums, i+1, 1, 0);
        ans=Math.max(cur,ans);
        }
        return ans;
    }

    long rec(int[] nums, int ci, int index, int del) {

        if (ci == nums.length) {
            return 0;
        }
        if(dp[ci][index][del]!=Integer.MIN_VALUE)
        return dp[ci][index][del];

        // Take nums[ci]
        int nextpar=index==1?0:1;
        long next = rec(nums, ci + 1, nextpar, del);

        long take=0;
        long c1=0;

        if (index % 2 == 0) {
            take = nums[ci] + next;
        } else {
            take = next - nums[ci];
        }
        c1=Math.max(c1,take);
        // Delete nums[ci]
        long delete = Long.MIN_VALUE;

        if (del == 0) {
            delete = rec(nums, ci + 1, index, 1);
        }

        return dp[ci][index][del]=Math.max(c1, delete);
    }
}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int sum=0;
        int minl=Integer.MAX_VALUE;
        for(int r=0;r<nums.length;r++)
        {
            sum+=nums[r];
            while(sum>=target)
            {
                if(r-l+1<minl)
                minl=r-l+1;
                sum=sum-nums[l];
                l++;
            }
        }
        return minl==Integer.MAX_VALUE?0:minl;
    }
}
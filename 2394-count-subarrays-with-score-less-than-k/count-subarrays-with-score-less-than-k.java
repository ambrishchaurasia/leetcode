class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans=0;
        long sum=0;
        int left=0;

        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];

            while(sum*(i-left+1)>=k)
            {
                sum=sum-nums[left];
                left++;
            }
            ans=ans+i-left+1;

        }
         return ans;

    }
}
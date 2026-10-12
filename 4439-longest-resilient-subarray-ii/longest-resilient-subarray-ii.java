class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int len=0;
        long sum=0;
        int prev=0;
        int max=0;
        int x=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
                if(prev%k==nums[i]%k){
                    if(sum%k==nums[i]%k)
                    len=i-x+1;
                }
                else
                {
                    x=i;
                    sum=nums[i];
                    len=1;
                }
                if(len>max)
                max=len;
                prev=nums[i];    
        }
        return max;
    }
}
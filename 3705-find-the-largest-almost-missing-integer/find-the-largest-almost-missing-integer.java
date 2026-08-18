class Solution {
    public int largestInteger(int[] nums, int k) {
        int mx=Integer.MIN_VALUE;
        int marl[]=new int[51];
        for(int i=0;i<nums.length;i++)
        {
            if(mx<nums[i])
            mx=nums[i];
            marl[nums[i]]++;
        }
        
        if(k==1)
        {
            int s=50;

            while(s>=0 && marl[s]!=1)
            {
                s--;
            }
            if(s==-1)
            return -1;
            return s;
        }
  
        else if(k>1)
        {
            int g=Math.max(nums[0],nums[nums.length-1]);
            int s=Math.min(nums[0],nums[nums.length-1]);

            if(k==nums.length)
            return mx;

            else if(marl[g]==1)
            return g;

            else if(marl[s]==1)
            {
                return s;
            }
            else
            return -1;
        }
        return -1;
        
    }
}
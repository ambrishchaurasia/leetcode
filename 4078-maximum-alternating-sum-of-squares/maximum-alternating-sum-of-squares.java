class Solution {
    public long maxAlternatingSum(int[] nums) {
        int numsc[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            numsc[i]=Math.abs(nums[i]);
        }
        Arrays.sort(numsc);
        int n=nums.length;
        int limit=(int)n/2;
        long ans=0;
        for(int i=numsc.length-1;i>=0;i--)
        {
            if(i>=limit)
            ans+=numsc[i]*numsc[i];
            else
            ans-=numsc[i]*numsc[i];
  
        }
        return ans;
    }
}
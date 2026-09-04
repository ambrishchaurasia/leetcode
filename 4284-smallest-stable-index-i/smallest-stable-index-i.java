class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int min[]=new int [nums.length];
        min[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--)
        {
            if(min[i+1]>nums[i])
            min[i]=nums[i];
            else
            min[i]=min[i+1];
        }
        for(int i=0;i<nums.length;i++)
        {
            if(max<nums[i])
            max=nums[i];
            System.out.print(min[i]);

            int score=max-min[i];
            if(score<=k)
            return i;
        }
        return -1;
    }
}
class Solution {
    public int[] leftRightDifference(int[] nums) {
        if(nums.length==1)
        return new int[]{0};
        int ls[]=new int[nums.length];
        ls[0]=0;
        for(int i=1;i<nums.length;i++)
        {
            ls[i]=nums[i-1]+ls[i-1];
        }
        int rs[]=new int[nums.length];
        rs[nums.length-1]=0;
        for(int i=nums.length-2;i>=0;i--)
        {
            rs[i]=rs[i+1]+nums[i+1];
        }
        for(int i=0;i<nums.length;i++)
        {
            ls[i]=Math.abs(ls[i]-rs[i]);
        }
        return ls;
    }
}
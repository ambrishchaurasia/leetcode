class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        boolean nz=false;
        for(int i=0;i<nums.length;i++)
        {
            xor=xor^nums[i];
            if(nums[i]!=0)
            nz=true;
        }

        if(xor!=0)
        return nums.length;

        else
        {
            if(nz)
            {
                return nums.length-1;
            }
            else
            {
                return 0;
            }
        }
    }
}

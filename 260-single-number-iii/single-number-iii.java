class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int i:nums)
        {
            xor=xor^i;
        }
        int b1=0;
        int b2=0;
        int rightmost_thatis_unmatching=(xor & xor-1)^xor;
        for(int i=0;i<nums.length;i++)
        {
            if((nums[i] & rightmost_thatis_unmatching)==rightmost_thatis_unmatching)
            b1=b1 ^ nums[i];
            else
            b2=b2^nums[i];
        }
        return new int[]{b1,b2};
    }
}
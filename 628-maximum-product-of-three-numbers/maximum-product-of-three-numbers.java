class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int ans=1;
        int sans=1;
        for(int i=nums.length-1;i>=nums.length-3;i--)
        {
            ans=ans*nums[i];
        }
         for(int i=0;i<2;i++)
        {
            sans=sans*nums[i];
        }
        sans=sans*nums[nums.length-1];
        return Math.max(sans,ans);
    }
}
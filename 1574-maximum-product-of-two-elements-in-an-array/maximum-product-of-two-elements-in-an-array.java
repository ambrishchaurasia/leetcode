class Solution {
    public int maxProduct(int[] nums) {
        int largest=-1;
        int sl=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(largest<nums[i]-1)
            {
                sl=largest;
                largest=nums[i]-1;
            }
            else if(sl<nums[i]-1)
            {
                sl=nums[i]-1;
            }
        }
        return sl*largest;
    }
}
class Solution {
    public boolean check(int[] nums) {
        int index=-1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]>nums[i+1])
            {
                index=i+1;
                break;
            }
        }
        if(index==-1)
        {
            return true;
        }
        int size=nums.length;
        for(int i=0;i<size-1;i++)
        {
            if(nums[index]<=nums[(index+1)%size])
            index=(index+1)%size;
            else
            return false;
        }
        return true;
    }
}
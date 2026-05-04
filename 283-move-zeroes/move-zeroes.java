class Solution {
    public void moveZeroes(int[] nums) {
        int i=-1;
        int j;
        for(int it=0;it<nums.length;it++)
        {
            if(nums[it]==0)
            {
                i=it;
                break;
            }
        }
        if(i==-1)
        return;
        
        j=i+1;
        //i always points to 0;
        while(j<nums.length)
        {
            if(nums[j]!=0)
            {
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
                j++;
                i++;
            }
            else
            {
            j++;
            }
        }

    }
}
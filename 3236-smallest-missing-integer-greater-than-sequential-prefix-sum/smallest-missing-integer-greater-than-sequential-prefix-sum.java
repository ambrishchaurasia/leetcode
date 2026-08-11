class Solution {
    public int missingInteger(int[] nums) { 

        if(nums.length==1)
        return nums[0]+1;

        boolean[] mark=new boolean[52];
        int csum=0;
        int i=0;
        while(i<nums.length)
        {
            while(i+1<nums.length && nums[i]+1==nums[i+1])
            {
            mark[nums[i]]=true;
            csum+=nums[i];
            i++;
            }

            mark[nums[i]]=true;
            csum+=nums[i];

            i++;

            while(i<nums.length)
            {
                mark[nums[i]]=true;
                i++;
            }
        }

        for(int it=csum;it<mark.length;it++)
        {
            if(!mark[it])
            return it;
        }
        return csum;
    }
}
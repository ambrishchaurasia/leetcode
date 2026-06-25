class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int []prefix=new int[nums.length];

        if(nums[0]==target)
        prefix[0]=1;
        
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==target)
            prefix[i]=prefix[i-1]+1;
            else
            prefix[i]=prefix[i-1];
        }
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i;j<nums.length;j++)
            {
                int length=j-i+1;
                int count=0;
                if(i>0)
                count=prefix[j]-prefix[i-1];
                else
                count=prefix[j];

                if(count>length/2)
                ans++;
            }
        }
        return ans;
    }
}
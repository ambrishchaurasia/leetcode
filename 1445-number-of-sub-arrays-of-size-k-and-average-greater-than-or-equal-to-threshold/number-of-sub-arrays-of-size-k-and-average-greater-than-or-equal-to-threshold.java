class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int sum=0;
        int l=0;
        int r=k;
        for(int i=0;i<k;i++)
        {
            sum=sum+nums[i];
        }

        int ans=0;
        double avg=(1.0*sum)/(1.0*k);
        if(avg>=threshold)
        ans++;

        while(r<nums.length)
        {
            sum=sum-nums[l];
            l++;
            sum=sum+nums[r];
            avg=(1.0*sum)/(1.0*k);
            if(avg>=threshold)
            {
                System.out.print(r);
            ans++;
            }
            r++;  
        }
        return ans;
    }
}
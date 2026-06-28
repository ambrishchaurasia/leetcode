class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<=31;i++)
        {
             int cnt=0;

            for(int num:nums)
            {
                if((num&(1<<i))!=0)
                cnt++;
            }
            if(cnt % 3!=0)
            ans=ans|(1<<i);
        }
        return ans;
    }
}
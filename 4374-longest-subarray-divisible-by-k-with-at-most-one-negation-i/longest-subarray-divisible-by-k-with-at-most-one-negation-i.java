class Solution {
    public int longestSubarray(int[] nums, int k) {
        int ans=-1;
        for(int i=0;i<nums.length;i++)
        {
            HashSet<Integer> hs=new HashSet<>();
            int sum=0;
            for(int j=i;j<nums.length;j++)
            {
                sum+=nums[j];
                int rem=(((2*nums[j])%k)+k)%k;
                int check=(((sum)%k)+k)%k;
                hs.add(rem);

                if(sum%k==0 || hs.contains(check) )
                {
                    int cur=j-i+1;
                    if(cur>ans)
                    ans=cur;
                }

            }
        }
        return ans==-1?0:ans;
    }
}
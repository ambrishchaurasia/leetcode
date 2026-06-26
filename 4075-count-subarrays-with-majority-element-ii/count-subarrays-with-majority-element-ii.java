class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        HashMap <Integer,Integer> hm =new HashMap();
        int curr=0;
        hm.put(0,1);
        long less=0;
        long ans=0;
    
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
            {
                less+=hm.get(curr);
                curr++;
                hm.put(curr,hm.getOrDefault(curr,0)+1);  
            }
            else
            {
                curr--;
                less-=hm.getOrDefault(curr,0);
                hm.put(curr,hm.getOrDefault(curr,0)+1);
            }
            ans+=less;
        }
        return ans;

    }
}
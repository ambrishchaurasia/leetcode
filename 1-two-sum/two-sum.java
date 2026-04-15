class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            hm.put(nums[i],i);
        }
        int ans[]=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            int rem=target-nums[i];
            int index=hm.getOrDefault(rem,-1);
            if(index!=-1 && index !=i)
            {
            ans=new int[]{i,index};
            break;
            }
        }
        return ans;
    }
}
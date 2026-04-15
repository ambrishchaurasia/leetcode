class Solution {
    public int majorityElement(int[] nums) {
        HashMap <Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int fre=hm.getOrDefault(nums[i],0);
            hm.put(nums[i],fre+1);
            if(fre+1>nums.length/2)
            return nums[i];
        }
        return 0;
    }
}
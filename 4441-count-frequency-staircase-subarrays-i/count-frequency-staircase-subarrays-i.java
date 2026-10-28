class Solution {
    public int countStaircase(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            HashMap<Integer,Integer> hm=new LinkedHashMap<>();
            for(int j=i;j<nums.length;j++)
            {
                hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
                int c=1;
                boolean valid=true;
                for(Map.Entry<Integer,Integer> it:hm.entrySet())
                {
                    int num=it.getKey();
                    int fre=it.getValue();
                    if(fre!=c)
                    {
                    valid=false;
                    break;
                    }
                    ++c;
                }
                if(valid && i!=j)
                {
                ans++;
                }

            }
        }
        return ans+nums.length;
    }
}
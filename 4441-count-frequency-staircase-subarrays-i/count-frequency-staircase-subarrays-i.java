class Solution {
    public int countStaircase(int[] nums) {
        int ans=0;
        
        for(int i=0;i<nums.length;i++)
        {
            int invalid=0;
            HashMap<Integer,int[]> hm=new LinkedHashMap<>();
            int c=1;
            for(int j=i;j<nums.length;j++)
            {
                if(!hm.containsKey(nums[j]))
                {
                hm.put(nums[j],new int[]{c++,1});
                if(c-1!=1)
                ++invalid;
                }
                else
                {
                    int arr[]=hm.get(nums[j]);
                    int idx=arr[0];
                    int fre=arr[1];

                    if(fre!=idx)
                    --invalid;

                    if(fre+1!=idx)
                    ++invalid;

                    if(invalid==0)
                    {
                        System.out.println("i="+i+"j="+j);
                    ++ans;
                    }
                    hm.put(nums[j],new int[]{idx,fre+1});
                }
            }
        }
        return ans+nums.length;
    }
}
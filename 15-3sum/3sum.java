class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++)
        {
            hm.put(nums[i],i);
        }

        for(int i=0;i<nums.length-1;i++)
        {
              if(i>0 && nums[i]==nums[i-1])
              continue;
            for(int j=i+1;j<nums.length;j++)
            {
                if(j>i+1 && nums[j]==nums[j-1])
               continue;
            
                int search=-1*(nums[i]+nums[j]);
                int index=hm.getOrDefault(search,-1);
                if(index!=-1 && index != i && index!=j)
            {
                    ArrayList<Integer> t=new ArrayList<>();
                if(index>j)
                    {
                    t.add(nums[i]);
                    t.add(nums[j]);
                    t.add(search);
                    ans.add(t);

                }

            }
            
        }
    }
    HashSet<ArrayList<Integer>> set=new HashSet(ans);
     List<List<Integer>> answer=new ArrayList<>();
   for(ArrayList<Integer> a:set)
   {
    answer.add(a);
   }
   return answer;
}
}

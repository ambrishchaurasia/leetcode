class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //bitwise apporach

         List<List<Integer>> ans=new ArrayList<>();
        int totalsubsets=(int) Math.pow(2,nums.length);
        for(int i=0;i<totalsubsets;i++)
        {
            ArrayList<Integer> curr=new ArrayList<>();
            for(int j=0;j<nums.length;j++)
            {
                if((i & (1<<j)) !=0)
                curr.add(nums[j]);
            }
            ans.add(curr);
        }
        return ans;
    }
}
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max=-1;
        int min=101;
        boolean vis[]=new boolean[101];
        for(int i=0;i<nums.length;i++)
        {
            vis[nums[i]]=true;

            if(nums[i]>max)
            max=nums[i];
            
            if(nums[i]<min)
            min=nums[i];
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=min;i<=max;i++)
        {
            if(!vis[i])
            ans.add(i);
        }
        return ans;
        
    }
}
class Solution {
    public void rotate(int[] nums, int k) {
        ArrayList<Integer> ans=new ArrayList<>();
        k=k%nums.length;
        int index=nums.length-k;
        if(k % nums.length==0)
        return;
        for(int i=0;i<nums.length;i++)
        {
            ans.add(nums[index]);
            index=(index+1)%nums.length;
        }
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=ans.get(i);
        }

    }
}
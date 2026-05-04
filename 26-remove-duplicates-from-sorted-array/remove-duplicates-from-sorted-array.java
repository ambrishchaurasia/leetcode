class Solution {
    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> arr=new ArrayList<>();
        Arrays.sort(nums);
        int c=0;
        int i=0;
        List<Integer> ans=new ArrayList<>();
        while(i<nums.length)
        {
            while(i<nums.length-1 && nums[i]==nums[i+1])
            {
              i++;
              
            }
            ans.add(nums[i]);
            c++;
            i++;
        }
        for(i=0;i<ans.size();i++)
        {
            nums[i]=ans.get(i);
        }
        return c;
    }
}
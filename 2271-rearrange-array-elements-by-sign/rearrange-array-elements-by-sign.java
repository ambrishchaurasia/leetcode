class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> neg=new ArrayList<>();
                ArrayList<Integer> pos=new ArrayList<>();


        for(int i=0;i<nums.length;i++)
        {
         if(nums[i]>0)
         pos.add(nums[i]);
         else
         neg.add(nums[i]);
        }
        int i=0;
        int j=0;
        int it=0;
        while(i<pos.size() && j<neg.size() && it<(pos.size()+neg.size()))
        {
          nums[it]=pos.get(i++);
          it++;
          nums[it]=neg.get(j++);
          it++;
        }
        while(i<pos.size())
        {
            nums[it]=pos.get(i++);
          it++;
        }
        while(j<neg.size())
        {
            nums[it]=neg.get(j++);
          it++;
        }
        return nums;
    }
}
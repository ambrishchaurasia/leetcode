class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> a1=new ArrayList<>();
        List<Integer> a2=new ArrayList<>();

        a1.add(nums[0]);
        a2.add(nums[1]);
        int a1l=nums[0];
        int a2l=nums[1];

        for(int i=2;i<nums.length;i++)
        {
          if(a1l>a2l)
          {
            a1.add(nums[i]);
            a1l=nums[i];
          }
          else
          {
            a2.add(nums[i]);
            a2l=nums[i];
          }
        }
        int i=0;
        int index=0;
        while(index<a1.size())
        {
            nums[i]=a1.get(index);
            index++;
            i++;
        }
        index=0;
        while(index<a2.size())
        {
            nums[i]=a2.get(index);
            index++;
            i++;
        }
        return nums;

    }
}
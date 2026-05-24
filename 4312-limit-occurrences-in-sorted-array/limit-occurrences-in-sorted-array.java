class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int c=1;
        if(nums.length==1)
        return nums;
        List<Integer> ans=new ArrayList<>();
        int i=0;
        while(i<nums.length-1)
        {
            ans.add(nums[i]);
            while(i<nums.length-1 && nums[i]==nums[i+1] && c<k )
            {
                c++;
                i++;
                ans.add(nums[i]);
            }
            c=1;
            while( i<nums.length-1 && nums[i]==nums[i+1] )
            {
                i++;
            }
           i++;
        }
        if(nums.length>1 && nums[nums.length-1]!=nums[nums.length-2])
        ans.add(nums[nums.length-1]);
        int[] answer=new int[ans.size()];
        for(int i1=0;i1<ans.size();i1++)
        {
            answer[i1]=ans.get(i1);
        }

        return answer;
        
    }
}
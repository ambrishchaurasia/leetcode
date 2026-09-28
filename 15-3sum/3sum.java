class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> hs=new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            while(i>0 && i<nums.length && nums[i]==nums[i-1])
            i++;

            int l=i+1;
            int r=nums.length-1;

            while(l<r)
            {
                while(l<r && nums[l]==nums[l-1] && l-1!=i)
                l++;
                while(l<r && r<nums.length-1 && r>i && nums[r]==nums[r+1])
                r--;
                if(l==r)
                continue;
                if(nums[i]+nums[l]+nums[r]==0)
                {
                    List<Integer> cur=new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[l]);
                    cur.add(nums[r]);
                    hs.add(cur);
                    l++;
                    r--;
                }
                else if(nums[i]+nums[l]+nums[r]<0)
                {
                    l++;
                }
                else
                {
                    r--;
                }

            }
        }
            List<List<Integer>> ans=new ArrayList<>(hs);
            return ans;
    }
}
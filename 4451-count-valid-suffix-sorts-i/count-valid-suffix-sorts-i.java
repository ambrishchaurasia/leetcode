class Solution {
    public int countSuffix(int[] nums, int[] target) {
        boolean[] valid=new boolean[nums.length];
        valid[0]=true;
        boolean [] rvalid=new boolean[nums.length];
        HashMap <Integer,Integer> hm=new HashMap<>();
        for(int i:nums)
        {
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i:target)
        {
            hm.put(i,hm.getOrDefault(i,0)-1);
            if(hm.get(i)==0)
            hm.remove(i);
        }
        if(hm.size()!=0)
        return 0;
        for(int i=1;i<nums.length;i++)
        {
            valid[i]=valid[i-1]&&nums[i-1]==target[i-1];
        }
        int i=nums.length-2;
        rvalid[nums.length-1]=true;
        while(i>=0)
        {
            if(target[i]<target[i+1])
            break;
            rvalid[i]=true;
            i--;
        }
        int ans=0;
        for(int k=0;k<nums.length;k++)
        {
          if(valid[k]&&rvalid[k])
          ++ans;
        }
        return ans;
    }
}
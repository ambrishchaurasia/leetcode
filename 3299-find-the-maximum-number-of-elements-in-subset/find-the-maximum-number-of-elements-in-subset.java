class Solution {
    public int maximumLength(int[] nums) {
          HashMap<Integer,Integer> fre=new HashMap();
        int ones=0;
        for(int i:nums)
        {
            if(i==1)
            ones++;
            else
            fre.put(i,fre.getOrDefault(i,0)+1);
        }
        if(ones%2==0)
        ones--;
        int ans=-1;

        for(Map.Entry<Integer,Integer> itr:fre.entrySet())
        {
            long num=itr.getKey();
            int len=0;
            while(true)
            {    
                int cnt=0;               
               if (num > Integer.MAX_VALUE) {
                cnt = 0;
                } else {
                 cnt = fre.getOrDefault((int) num, 0);
                    }
                if(cnt==1)
                {
                    len++;
                    break;
                }
                else if(cnt>=2)
                {
                len+=2;
                }
                else
                {
                    if(len%2==0)
                    len--;
    
                    break;
                }
                num=num*num;

            }
            if(ans<len)
            ans=len;
        }
        ans = Math.max(ans, ones);
        return ans;
    }
}
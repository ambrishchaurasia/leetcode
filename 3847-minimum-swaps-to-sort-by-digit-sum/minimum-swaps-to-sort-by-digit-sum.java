class Solution {
    int val(int x)
    {
        int sum=0;
        while(x!=0)
        {
            int r=x%10;
            sum+=r;
            x=x/10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        List<Integer> li=new ArrayList<>();
        for(int i:nums)
        {
            li.add(i);
        }
        Collections.sort(li,(a,b)->
        {
            if(val(a)==val(b))
            return a-b;
            else
            return val(a)-val(b);
        });

        HashMap<Integer,Integer> hm=new HashMap<>();
        int c=0;
        for(int i:nums)
        {
            hm.put(i,c);
            c=c+1;
        }
int ans=0;
        for(int i=0;i<li.size();i++)
        {
            //expected
            int ex=li.get(i);
            //act
            int act=hm.get(ex);

            if(i!=act)
            {
                int copy=nums[i];
                nums[i]=ex;
                nums[act]=copy;

                hm.put(ex,i);

                hm.put(copy,act);
                ans++;

            }

        }
        return ans;
    }
}
class Solution {
    public long maximizeSum(int[] nums, int k) {
        List<int[]> li=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int cur=nums[i];
            int arr[]=new int[10];
            while(cur!=0)
            {
                int num=cur%10;
                arr[num]++;
                 cur/=10;
            }
            int num=0;
            for(int it=9;it>=0;it--)
            {
                while(arr[it]>0)
                {
                    num=num*10+it;
                    arr[it]--;
                }
            }
            System.out.println(num);
            li.add(new int[]{nums[i],num-nums[i]});
        }
        Collections.sort(li,(a,b)->b[1]-a[1]);
        long ans=0;
        for(int i=0;i<li.size();i++)
        {
            if(k>0)
            {
                ans+=li.get(i)[1]+li.get(i)[0];
                k--;

            }
            else
            ans+=li.get(i)[0];

        }
        return ans;
    }
}
class Solution {
    boolean isValid(int []nums,int num,int []fre)
    {
     for(int i=0;i<501;i++)
     {
        if(fre[i]==0)
        continue;

        //x+y=num
        int o=num-i;
        if(o==i && fre[o]>=2)
        {
        System.out.println("x+y");

        return false;
        }
        else if(o!=i && o>=0 && fre[o]>=1)
        {

        return false;
        }

        //x+num=y
        o=num+i;
        if(o<=500 && i==num && fre[i]>=2 && fre[o]>=1)
        return false;
        else if(i!=num && o<=500 && fre[o]>=1)
        {

        return false;
        }
     }
     return true;

    }
    public int maxSubarray(int[] nums) {
        int l=0;
        int ans=-1;
        int fre[]=new int[501];
        if(nums.length<=2)
        return nums.length;
        fre[nums[0]]++;
        fre[nums[1]]++;
        for(int i=2;i<nums.length;i++)
        {
            fre[nums[i]]++;
           
            while(i-l>=2 && !isValid(nums,nums[i],fre))
            {
                System.out.println("left"+l);
                System.out.println("right"+i);

                fre[nums[l]]--;
                l++;
            }
           
            int cur=i-l+1;
                if(cur>ans)
                ans=cur;
        }
        return ans;
    }
}
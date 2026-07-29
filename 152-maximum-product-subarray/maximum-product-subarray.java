class Solution {
    public int maxProduct(int[] nums) {
        //logic ye hai ki agar odd negatives hn to hum actually first negative ko leke end tak jaege before last negative 
        // ya last negative se first negative ke pehle ruk jaege jisse even negatvies milen

        if(nums.length==1)
        return nums[0];
        int pre=1;
        int suf=1;

        int n=nums.length;
        int gre=-1;
        for(int i=0;i<nums.length;i++)
        {
            pre=pre*nums[i];
            suf=suf*nums[n-1-i];
            
            int cg=pre>suf?pre:suf;
            gre=Math.max(cg,gre);

            if(pre==0)
            pre=1;
            if(suf==0)
            suf=1;
         }
         return gre;
    }
}
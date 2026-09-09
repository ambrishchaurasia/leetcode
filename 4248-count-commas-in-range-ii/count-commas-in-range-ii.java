class Solution {
    public long countCommas(long n) {
        long s=1000;
        long e=999999;
        long ans=0;
        int k=1;
        while(e<=n)
        {
          ans+=(e-s+1)*k;
          s=s*1000;
          e=e*1000+999;
          k++;
          
        }

        if(s<=n)
        {
            ans= ans+(n-s+1)*k;
        }
        return  ans;

    }
}
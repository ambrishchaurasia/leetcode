class Solution {
    public long countCommas(long n) {
        long s=1000;
        long ans=0;
        int k=1;
        while(s<=n)
        {
          ans+=(n-s+1);
          s=s*1000;          
        }
        return ans;

    }
}
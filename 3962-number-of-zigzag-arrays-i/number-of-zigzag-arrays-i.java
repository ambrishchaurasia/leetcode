class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int m=r-l+1;
        long [][]dp=new long[m][2];
        long MOD=1000000000+7;

        //initialisation for length=2,number of seq that follows with length 2
        for(int i=0;i<m;i++)
        {
            dp[i][0]=m-1-i;
            dp[i][1]=i;
        }

        for(int i=2;i<n;i++)
        {
            long [][]nxtdp=new long[m][2];
            long []prefix=new long[m];
            long []suffix=new long[m];
            long sum=0;
            for(int j=0;j<m;j++)
            {
                sum=(sum+dp[j][0])%MOD;
                prefix[j]=sum;
            }
            sum=0;
            for(int j=m-1;j>=0;j--)
            {
                sum=(sum+dp[j][1])%MOD;
                suffix[j]=sum;
            }
            for(int v=0;v<m;v++)
            {
                if(v+1<m)
                nxtdp[v][0]=suffix[v+1];
                if(v-1>-1)
                nxtdp[v][1]=prefix[v-1];
            }
            dp=nxtdp;
        }
        long ans=0;
        for(int i=0;i<m;i++)
        {
            ans=(ans+dp[i][0]+dp[i][1])%MOD;
        }
        return (int)ans;


    }
}
class Solution {
    int dp[][];
    public int minCost(int n, int[] cuts){

        Arrays.sort(cuts);
   
        int cut[]=new int[cuts.length+2];
        cut[0]=0;
        for(int i=0;i<cuts.length;i++)
        {
            cut[i+1]=cuts[i];
        }
        cut[cut.length-1]=n;

        dp=new int[cut.length][cut.length];
        for(int i=0;i<cut.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }

        return rec(0,cut.length-1,cut);
        
    }

    int rec(int i,int j,int []cut)
    {
        if(j-i==1)
        return 0;

        if(dp[i][j]!=-1)
        return dp[i][j];

        int ans=Integer.MAX_VALUE;

        int len=cut[j]-cut[i];
        for(int k=i+1;k<=j-1;k++)
        {
          int cur=rec(i,k,cut)+rec(k,j,cut)+len;
          if(cur<ans)
          ans=cur;
        }
        return dp[i][j]=ans;

    }

}
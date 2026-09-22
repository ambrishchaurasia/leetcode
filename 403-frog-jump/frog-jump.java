class Solution {
    int dp[][];
    public boolean canCross(int[] stones) {
        dp=new int[stones.length+1][stones.length+1];
        for(int i=0;i<stones.length+1;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        if(stones[1]!=1)
        return false;
        boolean ans=rec(stones,1,1);
        return ans;
    }
    boolean rec(int []stones,int i,int lj)
    {
        if(i>=stones.length)
        return false;
        if(i==stones.length-1)
        return true;

        if(dp[i][lj]!=-1)
        {
        return dp[i][lj]==1?true:false;
        }
        
       boolean a= find(stones,i,lj+1);
      boolean b= find(stones,i,lj);
      boolean c=false;
        if(lj!=1)
        c= find(stones,i,lj-1);

        boolean answer=(a|b|c);
        if(answer==true)
        {
              dp[i][lj]=1;
              return true;
        }
        else
        {
              dp[i][lj]=0;
              return false;
        }
    }
    boolean find(int stones[],int idx,int lj)
    {
        int s=stones[idx]+lj;
        for(int i=idx+1;i<stones.length;i++)
        {
            if(stones[i]==s)
            return rec(stones,i,lj);
        }
        return false;
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean vis[]=new boolean[isConnected.length];
        int ans=0;
        for(int i=0;i<isConnected.length;i++)
        {
            if(!vis[i])
            {
                            ans++;

                vis[i]=true;
                rec(vis,isConnected,i);
            }
        }
      
        return ans;
    }
    void rec(boolean []vis,int[][]isConnected,int index)
    {
        for(int i=0;i<isConnected.length;i++)
        {
            if(isConnected[index][i]==1)
            {
                if(!vis[i])
                 {
                 vis[i]=true;
                 rec(vis,isConnected,i);
                 }
            }
         }
    }
}
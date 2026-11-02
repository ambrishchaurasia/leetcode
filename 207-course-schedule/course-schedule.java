class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i[]:prerequisites)
        {
            int x=i[0];
            int y=i[1];
            adj.get(y).add(x);
        }
        int vis[]=new int [numCourses];
        for(int i=0;i<numCourses;i++)
        {
            if(vis[i]==0)
            {
           boolean res= dfs(adj,i,vis);
           if(res==false)
           return false;
            }
        }
        return true;
    }
    boolean dfs(List<List<Integer>> adj,int i,int vis[])
    {
        vis[i]=1;

        for(int it=0;it<adj.get(i).size();it++)
        {
            int node=adj.get(i).get(it);
            if(vis[node]==0)
            {
                dfs(adj,node,vis);
            }
            if(vis[node]==1)
            return false;
        }
        vis[i]=2;
        return true;
    }
}
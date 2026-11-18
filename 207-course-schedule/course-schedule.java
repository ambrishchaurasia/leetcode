class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            int node=prerequisites[i][0];
            int par=prerequisites[i][1];

            adj.get(par).add(node);
        }
        int vis[]=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            if(vis[i]==0)
            {
            vis[i]=1;
            if(dfs(adj,i,vis)==false)
            return false;
            }
        }
        return true;

    }
    boolean dfs(List<List<Integer>> adj,int node,int []vis)
    {
        for(int i=0;i<adj.get(node).size();i++)
        {
            if(vis[adj.get(node).get(i)]==0)
            {
            vis[adj.get(node).get(i)]=1;
            if(dfs(adj,adj.get(node).get(i),vis)==false)
            return false;
            }
            else if(vis[adj.get(node).get(i)]==1)
            return false;
        }
        vis[node]=2;
        return true;
        
    }
}
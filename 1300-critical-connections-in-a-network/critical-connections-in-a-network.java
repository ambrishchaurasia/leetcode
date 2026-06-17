class Solution {
    int timer=1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.size();i++)
        {
            int node=connections.get(i).get(0);
            int nei =connections.get(i).get(1);
            adj.get(node).add(nei);
            adj.get(nei).add(node);
        }
        int vis[]=new int[n];
        int low[]=new int [n];
        int time[]=new int[n];
        List<List<Integer>> ans=new ArrayList<>();
        dfs(0,-1,vis,low,time,ans,adj);
        return ans;

    }
    void dfs(int node,int par,int []vis,int []low,int []time,List<List<Integer>> ans,List<List<Integer>> adj)
    {
        vis[node]=1;
        time[node]=timer;
        low[node]=timer;
         timer++;

        for(Integer a:adj.get(node))
        {
            if(a==par)
            continue;
            if(vis[a]==0)
            {
                dfs(a,node,vis,low,time,ans,adj);
                low[node]=Math.min(low[node],low[a]);
                if(low[a]>time[node])
                {
                    List<Integer> t=new ArrayList<>();
                    t.add(node);
                    t.add(a);
                    ans.add(t);
                }
            }
            else
            {
                low[node]=Math.min(low[node],low[a]);
            }
        }
    }
}
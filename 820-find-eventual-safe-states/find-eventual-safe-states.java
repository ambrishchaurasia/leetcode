class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean vis[]=new boolean[graph.length];
        boolean pathvis[]=new boolean[graph.length];
        boolean eventualsafe[]=new boolean[graph.length];
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
            {
            if(dfs(graph,i,vis,pathvis,eventualsafe))
            eventualsafe[i]=false;
            else
            eventualsafe[i]=true;


            }
        }
        for(int i=0;i<graph.length;i++)
        {
            if(eventualsafe[i])
            ans.add(i);
        }
        return ans;

    }
        boolean dfs(int[][] graph,int i,boolean [] vis,boolean []pathvis,boolean []eventualsafe)
        {
             vis[i]=true;
             pathvis[i]=true;
            for(int x=0;x<graph[i].length;x++)
            {
                if(!vis[graph[i][x]])
                {
                    if(dfs(graph,graph[i][x],vis,pathvis,eventualsafe))
                    {
                    eventualsafe[graph[i][x]]=false;
                    return true;
                    }
                }
                else if(pathvis[graph[i][x]])
                {
                    eventualsafe[graph[i][x]]=false;
                    return true;
                }
            }
                pathvis[i]=false;
                 eventualsafe[i] = true;
                return false;

        }
}
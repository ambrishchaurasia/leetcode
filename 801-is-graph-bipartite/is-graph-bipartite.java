class Solution {
    boolean dfs(int node,int c,int []color,int[][]graph)
    {
        color[node]=c;
        for(int n:graph[node])
        {
            //not visited
            if(color[n]==-1)
            {
                boolean ans=dfs(n,1-c,color,graph);
                if(ans==false)
                return false;

            }
            else
            {
                if(color[n]!=1-c)
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int color[]=new int [graph.length];
        for(int i=0;i<color.length;i++)
        {
            color[i]=-1;
        }

        for(int nodes=0;nodes<graph.length;nodes++)
        {
            if(color[nodes]==-1)
            {
         boolean ans=   dfs(nodes,0,color,graph);
         if(ans==false)
         return false;
            }
        }
        return true;
    }
}

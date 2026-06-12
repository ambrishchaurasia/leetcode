class Solution {
static final int MOD = 1_000_000_007;
        List<Integer>adj[];
        int depth[];
        long []pow2;
        int n;
        int col;
        int [][]ancestor;
        void dfs(int root,int parent)
        {
            ancestor[root][0]=parent;

            for(int nei:adj[root])
            {
                if(nei==parent)
                continue;

                depth[nei]=depth[root]+1;
                dfs(nei,root);
            }
        }
        void buildATable()
        {
            for(int i=1;i<col;i++)
            {
                for(int node=0;node<n;node++)
                {
                    if(ancestor[node][i-1]!=-1)
                    ancestor[node][i]=ancestor[ancestor[node][i-1]][i-1];
                }
            }
        }
        int findLCA(int u,int v)
        {
            if(depth[u]<depth[v])
            {
                int t=u;
                u=v;
                v=t;
            }
            int k=depth[u]-depth[v];

            for(int j=0;j<col;j++)
            {
if((k & (1<<j)) != 0)
                u=ancestor[u][j];

            }

            if(u==v)
            return v;

            for(int j=col-1;j>=0;j--)
            {
                if(ancestor[u][j]==-1)
                continue;

                int a_u=ancestor[u][j];
                int a_v=ancestor[v][j];
                if(a_u!=a_v)
                {
                    u=a_u;
                    v=a_v;
                }
            }
            return ancestor[u][0];
            
        }
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        n=edges.length+1;
        depth=new int[n];
        col=(int)(Math.log(n)/Math.log(2))+1;
        adj = new ArrayList[n];

         for(int i=0;i<edges.length+1;i++)
        {
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0]-1;
            int v=edges[i][1]-1;
            adj[u].add(v);
            adj[v].add(u);
        }
            ancestor = new int[n][col];
for(int i=0;i<n;i++){
    Arrays.fill(ancestor[i], -1);
}
        dfs(0,-1);
        buildATable();

        pow2=new long[n+1];
        pow2[0]=1;

        for(int i= 1;i<n+1;i++)
        {
           pow2[i]=((long)pow2[i-1]*2)%MOD;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++)
        {
            int u=queries[i][0]-1;
            int v=queries[i][1]-1;

            int lca=findLCA(u,v);
            int d=depth[u]+depth[v]-2*depth[lca];

            if(d==0)
            ans.add(0);
            else
ans.add((int)pow2[d-1]);
        }
        int[] res = new int[ans.size()];

for(int i=0;i<ans.size();i++)
{
    res[i] = ans.get(i);
}

return res;
        
    }
}
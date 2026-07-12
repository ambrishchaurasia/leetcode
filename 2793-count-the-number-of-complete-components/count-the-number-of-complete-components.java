class Solution {
   int [] bfs(List<List<Integer>> adj,int i ,boolean visited[])
    {
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(i);
        
        int v=0;
        int e=0;

        while(!queue.isEmpty())
        {
            int a=queue.poll();
            if(visited[a])
            continue;

            visited[a]=true;

            v++;
            for(int it=0;it<adj.get(a).size();it++)
            {
                int nei=adj.get(a).get(it);
                e++;
                if(!visited[nei])
                {
                    queue.offer(nei);
                }
            }
        }
        return new int[]{v,e};
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean visited[]=new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                int a[]=bfs(adj,i,visited);
                int v=a[0];
                int e=a[1];
                if(v*(v-1)==e)
                ans++;
            }

        }
        return ans;
    }
}
class State
{
    int node;
    int wt;
    int streak;
    State(int node,int wt,int streak)
    {
        this.node=node;
        this.wt=wt;
        this.streak=streak;
    }
}
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if(n==1)
        return 0;
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int node=edges[i][0];
            int nei=edges[i][1];
            int wt=edges[i][2];
            adj.get(node).add(new int[]{nei,wt});
        }
        PriorityQueue<State> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
        pq.offer(new State(0,0,1));
        long dist[][]=new long[n][k+1];
        for(int i=0;i<dist.length;i++)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        while(!pq.isEmpty())
        {
            State a=pq.poll();
            int nod=a.node;
            int wei=a.wt;
            int str=a.streak;

            if(dist[nod][str]<wei)
            continue;
            for(int []nei:adj.get(nod))
            {
                int curstr=str;
                int nNod=nei[0];
                int nWei=nei[1];
                char ch=labels.charAt(nNod);

                if(ch==labels.charAt(nod))
                    curstr++;
                else
                    curstr=1;
                
                if(curstr>k)
                continue;

                if(nWei+wei<dist[nNod][curstr])
                {
                    dist[nNod][curstr]=nWei+wei;
                    pq.offer(new State(nNod,nWei+wei,curstr));
                }
            }
        }
        long ans=Long.MAX_VALUE;
        for(int i=0;i<=k;i++)
        {
            ans=Math.min(ans,dist[n-1][i]);
        }
        if(ans==Integer.MAX_VALUE)
        return -1;

        return (int)ans;
    }
}
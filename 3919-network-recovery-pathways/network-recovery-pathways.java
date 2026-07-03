class Pair{
    int x;
    int wei;
    Pair(int x,int wei)
    {
        this.x=x;
        this.wei=wei;
    }
}

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        List<List<int[]>> adj=new ArrayList<>();
         for(int i=0;i<online.length;i++)
        {
                adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
                int node=edges[i][0];
                int nei=edges[i][1];
                int wei=edges[i][2];

                if(!online[node]||!online[nei])
                continue;
                adj.get(node).add(new int[]{nei,wei});
        }
        int l=0;
        int r=Integer.MAX_VALUE;
        int answer=-1;
        int n=online.length;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(dijkstra(k,mid,adj,n))
            {
                answer=mid;
                l=++mid;
            }
            else
            r=mid-1;
        }
        return answer;
    }
    boolean dijkstra(long k,int mid, List<List<int[]>> adj,int n)
    {

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.wei-b.wei);
        pq.offer(new Pair(0,0));
        int dis[]=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;
        
        while(!pq.isEmpty())
        {
            Pair a=pq.poll();
            int x=a.x;
            int wei=a.wei;

            if(x==n-1)
            return true;

            if(dis[x]<wei)
            continue;

            for(int []nb:adj.get(x))
            {
                int cn=nb[0];
                int cw=nb[1];
                
                int cwei=wei+cw;

                if(cwei>k || cw<mid)
                continue;
                

                if(dis[cn]>cwei)
                {
                pq.offer(new Pair(cn,cwei));
                dis[cn]=cwei;
                }
           
            }

        }
        return false;
    }
}
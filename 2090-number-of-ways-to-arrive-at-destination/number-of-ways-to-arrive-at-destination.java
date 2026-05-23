class Pair
{
    int d;
    long w;
    Pair(int d,long w)
    {
        this.d=d;
        this.w=w;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj=new ArrayList<>();
    long MOD = 1000000007;

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<roads.length;i++)
        {
          int node=roads[i][0];
          int dest=roads[i][1];
          int weight=roads[i][2];

          adj.get(node).add(new Pair(dest,weight));
          adj.get(dest).add(new Pair(node,weight));
        }
        
        long dis[]=new long[n];
        int ways[]=new int[n];
        ways[0]=1;
        for(int i=0;i<n;i++)
        {
            dis[i]=Long.MAX_VALUE;
        }
        dis[0]=0;

          PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.w,b.w));
          pq.offer(new Pair(0,0));
          while(!pq.isEmpty())
          {
            Pair a=pq.poll();
            int no=a.d;
            long we=a.w;
            if (we>dis[no]) 
            continue;

            List<Pair> neighbors=adj.get(no);
            for(int i=0;i<neighbors.size();i++)
            {
                Pair p=neighbors.get(i);
                int nei=p.d;
                long wei=p.w;

                if(dis[nei]>we+wei)
                {
                    dis[nei]=we+wei;
                    pq.offer(new Pair(nei,we+wei));
                    ways[nei]=ways[no];

                }
                else if(dis[nei]==we+wei)
                {
                    ways[nei]=(int) ((ways[no]+ways[nei])%MOD);
                }
            }
          }
          return ways[n-1];
        }
    }

class Pair
{
    int target;
    int weight;
    Pair(int target,int weight)
    {
        this.target=target;
        this.weight=weight;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
        adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++)
        {
            int src=times[i][0];
            adj.get(src).add(new Pair(times[i][1],times[i][2]));
        }
        int dis[]=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            dis[i]=Integer.MAX_VALUE;
        }
        dis[k]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.offer(new Pair(k,0));
        while(!pq.isEmpty())
        {
            Pair a=pq.poll();
            int node=a.target;
            int weight=a.weight;

            for(int i=0;i<adj.get(node).size();i++)
            {
               Pair x=adj.get(node).get(i);
               int nod=x.target;
               int d=x.weight;
               if(d+weight<dis[nod])
               {
                dis[nod]=d+weight;
                pq.offer(new Pair(nod,d+weight));
               }
            }
        }
        int max=-1;
        for(int i=1;i<dis.length;i++)
        {
            if(dis[i]==Integer.MAX_VALUE)
            return -1;
            if(max<dis[i])
            max=dis[i];
        }
        return max;


    }
}
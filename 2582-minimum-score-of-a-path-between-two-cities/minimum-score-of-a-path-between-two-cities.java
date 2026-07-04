class Pair
{
    int node;
    int wei;
    Pair(int node,int wei)
    {
        this.node=node;
        this.wei=wei;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.wei-b.wei);
        List<List<int[]>> adj=new ArrayList<>();
        int mindis[]=new int[n];
        Arrays.fill(mindis,Integer.MAX_VALUE);
        

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++)
        {
            int n1=roads[i][0]-1;
            int n2=roads[i][1]-1;
            int wei=roads[i][2];
            adj.get(n1).add(new int[]{n2,wei});
            adj.get(n2).add(new int[]{n1,wei});
        }
        pq.offer(new Pair(0,Integer.MAX_VALUE));
        while(!pq.isEmpty())
        {
            Pair a=pq.poll();
            int node=a.node;
            int wei=a.wei;

             

            for(int[]neib:adj.get(node))
            {
                int neinode=neib[0];
                int neiwei=neib[1];
                int currmin=Math.min(neiwei,wei);

                if(mindis[neinode]>currmin)
                {
                mindis[neinode]=currmin;
                pq.offer(new Pair(neinode,currmin));
                }
            }
        }
        return mindis[n-1];
    }
}
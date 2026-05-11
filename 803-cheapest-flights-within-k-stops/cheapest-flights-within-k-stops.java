class Triple
{
    int stops;
    int node;
    int weight;
    Triple(int stops,int node,int weight)
    {
        this.stops=stops;
        this.node=node;
        this.weight=weight;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++)
        {
            int sorc=flights[i][0];
            int dest=flights[i][1];
            int weight=flights[i][2];
            adj.get(sorc).add(new int[]{dest,weight});
        }
        int distance[]=new int[n];
        Queue<Triple> queue =new LinkedList<>();
        queue.offer(new Triple(0,src,0));
        for(int i=0;i<n;i++)
        {
            distance[i]=Integer.MAX_VALUE;
        }

       distance[src]=0;
        while(!queue.isEmpty())
        {
            Triple a=queue.poll();
            int s=a.stops;
            int node=a.node;
            int w=a.weight;
            if(s>k)
            break;

            for(int i=0;i<(adj.get(node)).size();i++)
            {
                int arr[]=adj.get(node).get(i);
                if(distance[arr[0]]>w+arr[1])
                {
                    distance[arr[0]]=w+arr[1];
                    queue.offer(new Triple(s+1,arr[0],w+arr[1]));
                }
            }

        }
        return distance[dst]==Integer.MAX_VALUE?-1:distance[dst];
        
    }
}
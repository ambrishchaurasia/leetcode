class Solution {
    public long[] earliestActivationTimes(int n, int[][] edges, int[] requiredSignals) {
        List<List<long[]>> adj=new ArrayList<>();
        long[]ans=new long[n];
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int par=edges[i][0];
            int chi=edges[i][1];
            int del=edges[i][2];
            adj.get(par).add(new long[]{chi,del});
        }
        int indeg[]=new int[n];
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->(int)(a[1]-b[1]));
        requiredSignals[0]=1;

        pq.offer(new long[]{0,0});
        Arrays.fill(ans,-1);

        while(!pq.isEmpty())
        {
            long a[]=pq.poll();
            int nei=(int)a[0];
            long tim=a[1];
            indeg[nei]++;

            //activated
            if(indeg[nei]==requiredSignals[nei])
            {
                ans[nei]=tim;
                for(int i=0;i<adj.get(nei).size();i++)
                {
                    pq.offer(new long[]{adj.get(nei).get(i)[0],tim+adj.get(nei).get(i)[1]});
                }
            }

        }
        return ans;

    }
}

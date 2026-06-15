class Solution {
    public int swimInWater(int[][] grid) {
        //min wt path from 0 to n-1 
        PriorityQueue <int[]> pq =new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        int[] r={0,-1,0,1};
        int[] c={-1,0,1,0};
        int n=grid.length;
                    boolean vis[][]=new boolean [n][n];
                    int min_maxtime=Integer.MAX_VALUE;
        pq.offer(new int[]{0,0,grid[0][0]});
        while(!pq.isEmpty())
        {
            int a[]=pq.poll();
            int row=a[0];
            int col=a[1];
            int time=a[2];
            if(vis[row][col])
            continue;

            vis[row][col]=true;

            for(int i=0;i<r.length;i++)
            {
                int adjr=row+r[i];
                int adjc=col+c[i];
                if(adjr >=0 && adjr<n && adjc>=0 && adjc<n)
                {
                int adjtime=grid[adjr][adjc];
                
                if(adjr ==n-1 && adjc==n-1 )
                return Math.max(time,adjtime);
                if(!vis[adjr][adjc])
                {
                    pq.offer(new int[]{adjr,adjc,Math.max(time,adjtime)});
                }
                }
            }

        }
        return 0;
    }
}
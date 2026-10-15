class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue=new LinkedList<>();
        boolean fal=false;

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                queue.offer(new int[]{i,j});

                if(grid[i][j]==1)
                fal=true;

            }
        }
        if(queue.isEmpty() && !fal)
        return 0;
        int ans=0;
        while(!queue.isEmpty())
        {
            int n=queue.size();
            for(int j=0;j<n;j++)
            {
            int[]arr=queue.poll();
            int x=arr[0];
            int y=arr[1];
            int a1[]={0,-1,0,1};
            int a2[]={-1,0,1,0};

            for(int i=0;i<4;i++)
            {
                int cx=x+a1[i];
                int cy=y+a2[i];

                if(cx>=0 && cx<grid.length && cy>=0 && cy<grid[0].length)
                {
                    if(grid[cx][cy]==1)
                    {
                        grid[cx][cy]=2;
                        queue.offer(new int[]{cx,cy});
                    }
                }
            }

            }
            ans++;
         }
         
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                return -1;
            }
        }
            return ans-1;
    }
}
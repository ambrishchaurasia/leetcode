class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if((i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1) && grid[i][j]==1)
                {
                grid[i][j]=2;
                queue.offer(new int[]{i,j});
                }
            }
        }
        int row[]={0,-1,0,1};
        int col[]={-1,0,1,0};

        while(!queue.isEmpty())
        {
            int a[]=queue.poll();
            int x=a[0];
            int y=a[1];
            for(int i=0;i<4;i++)
            {
                int cx=x+row[i];
                int cy=y+col[i];

                if(cx>=0 && cy>=0 && cx<grid.length && cy<grid[0].length && grid[cx][cy]==1)
                {
                    grid[cx][cy]=2;
                    queue.offer(new int[]{cx,cy});

                }

            }
        }
        int ans=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                ++ans;
            }
        }
        return ans;

    }
}
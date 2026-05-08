class Co
{
    int dis;
    int x;
    int y;
    Co(int dis,int x,int y)
    {
        this.dis=dis;
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Co> queue=new LinkedList<>();
        if(grid[0][0]==0)
        {
        queue.offer(new Co(1,0,0));
        }
        else
        return -1;
        int row[]={0,-1,-1,-1,0,1,1,1};
        int col[]={-1,-1,0,1,1,1,0,-1};

        int[][] dis=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                dis[i][j]=Integer.MAX_VALUE;
            }
        }

        dis[0][0]=1;
        int ans=-1;
        while(!queue.isEmpty())
        {
            Co a=queue.poll();
            int dist=a.dis;
            int x=a.x;
            int y=a.y;
            if(y==grid[0].length-1 && x==grid.length-1)
            {
                ans=dist;
                break;
            }

            for(int i=0;i<row.length;i++)
            {
                
                int x1=x+row[i];
                int y1=y+col[i];
                if(x1>=0 && x1<grid.length && y1>=0 && y1<grid[0].length && grid[x1][y1]==0)
                {
                    if(dis[x1][y1]>dist+1)
                    {
                    dis[x1][y1]=dist+1;
                    queue.offer(new Co(dist+1,x1,y1));
                    }
                }
            }
        }
        return dis[grid.length-1][grid[0].length-1]==Integer.MAX_VALUE?-1:dis[grid.length-1][grid[0].length-1];

        
    }
}
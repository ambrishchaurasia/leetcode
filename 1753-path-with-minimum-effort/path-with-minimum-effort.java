class Trio{
int dis;
int x;
int y;
Trio(int dis,int x,int y)
{
    this.dis=dis;
    this.x=x;
    this.y=y;
}
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        if(heights.length==1 && heights[0].length==1)
        return 0;
        int row[]={0,-1,0,1};
        int col[]={-1,0,1,0};
        int distance[][]=new int[heights.length][heights[0].length];
        for(int i=0;i<heights.length;i++)
        {
            for(int j=0;j<heights[0].length;j++)
            {
                distance[i][j]=Integer.MAX_VALUE;
            }
        }
        PriorityQueue <Trio>pq =new PriorityQueue<>((a,b)->a.dis-b.dis);
        pq.offer(new Trio(0,0,0));
        while(!pq.isEmpty())
        {
            Trio a=pq.poll();
            int dis=a.dis;
            int x=a.x;
            int y=a.y;

            for(int i=0;i<4;i++)
            {
                int nx=x+row[i];
                int ny=y+col[i];
                if(nx>=0 && nx<heights.length && ny>=0 && ny<heights[0].length)
                {
                    int abd=Math.abs(heights[nx][ny]-heights[x][y]);
                    int newdis=Math.max(dis,abd);
                    if(newdis<distance[nx][ny])
                    {
                        pq.offer(new Trio(newdis,nx,ny));
                        distance[nx][ny]=newdis;
                    }

                }
            }
        }
             return distance[heights.length-1][heights[0].length-1]==Integer.MAX_VALUE?-1:distance[heights.length-1][heights[0].length-1];

    }
}
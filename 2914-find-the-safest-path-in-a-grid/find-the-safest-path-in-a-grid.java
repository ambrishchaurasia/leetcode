class Pair
{
    int x;
    int y;
    int dis;
    Pair(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    Pair(int x,int y,int dis)
    {
        this.x=x;
        this.y=y;
        this.dis=dis;
    }
}
class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
                Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i<grid.size();i++)
        {
            for(int j=0;j<grid.get(0).size();j++)
            {
                if(grid.get(i).get(j)==1)
                {
                grid.get(i).set(j,0);
                queue.offer(new Pair(i,j));
                }
                else
                grid.get(i).set(j,-1);
            }
        }
        int row[]={0,-1,0,1};
        int col[]={-1,0,1,0};
        while(!queue.isEmpty())
        {
            Pair a=queue.poll();
            int r=a.x;
            int c=a.y;
            for(int i=0;i<4;i++)
            {
                int newr=r+row[i];
                int newc=c+col[i];
                if(newr>=0 && newr<grid.size() && newc>=0 && newc<grid.get(0).size())
                {
                if(grid.get(newr).get(newc)!=-1)
                continue;
                int dis=grid.get(r).get(c)+1;
                grid.get(newr).set(newc,dis);
                queue.offer(new Pair(newr,newc));
                }
            }
        }


        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.dis-a.dis);
        pq.offer(new Pair(0,0,grid.get(0).get(0)));
        boolean vis[][] = new boolean[grid.size()][grid.size()];
        while(!pq.isEmpty())
        {
            Pair a=pq.poll();
            int x=a.x;
            int y=a.y;
            int dis=a.dis;
            if(vis[x][y])
            continue;
            if(x==grid.size()-1 && y==grid.size()-1)
            return dis;

            vis[x][y]=true;

            for(int i=0;i<4;i++)
            {
                int newr=x+row[i];
                int newc=y+col[i];
                 if(newr>=0 && newr<grid.size() && newc>=0 && newc<grid.get(0).size())
                 {
                int newdis=grid.get(newr).get(newc);
                
                int distance=Math.min(dis,newdis);
                if((newr==grid.size()-1) && (newc==grid.size()-1))
                return distance;
                if(!vis[newr][newc] )
                {
                    pq.offer(new Pair(newr,newc,distance));
                }
                }
            }
        }    
        return 0;
    }
}
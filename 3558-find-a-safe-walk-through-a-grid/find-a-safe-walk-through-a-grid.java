class Pair{
    int x;
    int y;
    int weight;
    Pair(int x,int y,int weight)
    {
        this.x=x;
        this.y=y;
        this.weight=weight;
    }
}
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.weight-a.weight);
        int currh=health;
        if(grid.get(0).get(0)==1)
        currh--;
        pq.offer(new Pair(0,0,currh));
        boolean vis[][]=new boolean[grid.size()][grid.get(0).size()];
        int row[]={0,-1,0,1};
        int col[]={-1,0,1,0};

        while(!pq.isEmpty())
        {
            Pair a=pq.poll();
            int x=a.x;
            int y=a.y;
            int wei=a.weight;

            if(x==grid.size()-1 && y==grid.get(0).size()-1)
            return true;

            if(vis[x][y])
            continue;

            vis[x][y]=true;
            for(int i=0;i<4;i++)
            {
                int x1=x+row[i];
                int y1=y+col[i];
              
                if(x1<grid.size() && x1>=0 && y1<grid.get(0).size() && y1>=0 && !vis[x1][y1])
                {
                    int ch=0;
                    if(grid.get(x1).get(y1)==1)
                    ch=wei-1;
                    else
                    ch=wei;
                    if(ch>=1)
                    pq.offer(new Pair(x1,y1,ch));
                }
            }
        }
        return false;
    }
}
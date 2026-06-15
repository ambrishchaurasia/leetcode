class DisjointSet
{
    int []ulp;
    int []rank;
    DisjointSet(int n)
    {
     ulp=new int[n];
     rank=new int[n];
     for(int i=0;i<n;i++)
     {
        ulp[i]=i;
        rank[i]=1;
     }
    }
    int findulp(int n)
    {
        if(ulp[n]==n)
        return n;

        int up=findulp(ulp[n]);
        ulp[n]=up;
        return up;
    }
    void ubr(int u,int v)
    {
     int uu = findulp(u);
     int uv = findulp(v);
        if(uu==uv)
        return;
        
        int ru=rank[uu];
        int rv=rank[uv];
        if(ru>rv)
        {
            ulp[uv]=uu;
        }
        else if(rv>ru)
        {
            ulp[uu]=uv;
        }
        else
        {
            ulp[uu]=uv;
            rank[uv]=rank[uv]+1;
        }
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int []r={0,-1,0,1};
        int []c={-1,0,1,0};
        int n=grid.length;
        int pos[][]=new int[n*n][2];

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
                pos[grid[i][j]]=new int[]{i,j};
            }
        }
        DisjointSet ds=new DisjointSet(n*n);
        boolean [][]active =new boolean[n][n];
        for(int i=0;i<n*n;i++)
        {
            int a[]=pos[i];
            int ro=a[0];
            int co=a[1];
            int node=ro*n+co;
            int lastnode=n*n -1;
            active[ro][co]=true;
            for(int j=0;j<r.length;j++)
            {
                int adjr=ro+r[j];
                int adjc=co+c[j];
                int adjnode=adjr*n+adjc;
                if(adjr>=0 && adjr<n && adjc >=0 && adjc<n)
                {
                if(active[adjr][adjc])
                {
                   int ulp1 =ds.findulp(node);
                    int ulp2=ds.findulp(adjnode);
                    if(ulp1!=ulp2)
                    {
                        ds.ubr(ulp1,ulp2);
                    }
                    if(ds.findulp(0)==ds.findulp(lastnode))
                    return i;
                }}} }
                    return 0;
                      }
}
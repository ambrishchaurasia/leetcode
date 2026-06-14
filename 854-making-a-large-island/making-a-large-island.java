class Dsu{
    List<Integer> ulp=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    Dsu(int n)
    {
        for(int i=0;i<n;i++)
        {
            ulp.add(i);
            size.add(1);
        }
    }

    int findulp(int n)
    {
        if(ulp.get(n)==n)
        return n;

        int ans=findulp(ulp.get(n));
        ulp.set(n,ans);
        return ans;
    }
    void ubs(int u,int v)
    {
        int uu=findulp(u);
        int uv=findulp(v);
        if(uu == uv)
        return;

        if(size.get(uu)>size.get(uv))
        {
            ulp.set(uv,uu);
            int sizee=size.get(uu)+size.get(uv);
            size.set(uu,sizee);
        }
       else if(size.get(uu)<size.get(uv))
        {
            ulp.set(uu,uv);
            int sizee=size.get(uu)+size.get(uv);
            size.set(uv,sizee);
        }
        else
        {
             ulp.set(uu,uv);
            int sizee=size.get(uu)+size.get(uv);
            size.set(uv,sizee);
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        Dsu d=new Dsu(grid.length*grid.length);
        for(int i=0;i<grid.length;i++)
        {
            for(int k=0;k<grid.length;k++)
            {
            if(grid[i][k]==0) continue;

             int n1=i*grid.length+k;

            int[] row={0,-1,0,1};
            int[] col={-1,0,1,0};
            for(int j=0;j<row.length;j++)
            {
                int adjr=i+row[j];
                int adjc=k+col[j];
                int n2=adjr*grid.length+adjc;
                if(adjr>=0 && adjr<grid.length && adjc>=0 && adjc<grid.length)
                {
                if(grid[adjr][adjc]==1)
                {
                        if(d.findulp(n1)!=d.findulp(n2))
                        {
                            d.ubs(n1,n2);
                        }  
                }
                }
            }

        }
        }
        //all 1s connected
        int max=d.size.get(d.ulp.get(0));

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                HashSet <Integer> set=new HashSet<>();
                if(grid[i][j]==0)
                {
                    
            int[] row={0,-1,0,1};
            int[] col={-1,0,1,0};
            for(int k=0;k<row.length;k++)
            {
                int adjr=i+row[k];
                int adjc=j+col[k];
                if(adjr>=0 && adjr<grid.length && adjc>=0 && adjc<grid.length && grid[adjr][adjc]==1)
                {
                   int n2=adjr*grid.length+adjc;
                   int ulp=d.findulp(n2);
                   set.add(ulp);
                }
            }
            int curr=1;
            for(int uni:set)
            {
                curr+=d.size.get(uni);
            }
            if(max<curr)
            max=curr;
        }
        
    }
}
return max;
}
}
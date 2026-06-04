class DisjointSet
{
    List<Integer> ulp=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();
    DisjointSet(int n)
    {
     for(int i=0;i<n;i++)
     {
        ulp.add(i);
        rank.add(0);
     }
    }
     int findulp(int node)
     {
        if(ulp.get(node)==node)
        return node;
        int up=findulp(ulp.get(node));
        ulp.set(node,up);
        return up; 
     }
     void ubr(int u,int v)
     {
        int ulp_u=findulp(u);
        int ulp_v=findulp(v);
        if(ulp_u==ulp_v)
        return;

        if(rank.get(ulp_u)>rank.get(ulp_v))
        ulp.set(ulp_v,ulp_u);

       else if(rank.get(ulp_v)>rank.get(ulp_u))
        ulp.set(ulp_u,ulp_v);
        else
        {
        ulp.set(ulp_u,ulp_v);
            rank.set(v,rank.get(v)+1);
        }
        
      }
    }
class Solution {
    public int removeStones(int[][] stones) {
        int maxr=Integer.MIN_VALUE;
        int maxc=Integer.MIN_VALUE;

        for(int i=0;i<stones.length;i++)
        {
            if(maxr<stones[i][0])
            maxr=stones[i][0];

             if(maxc<stones[i][1])
            maxc=stones[i][1];
        }
        DisjointSet ds=new DisjointSet(maxc+maxr+2);
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<stones.length;i++)
        {
            int u=stones[i][0];
            int v=stones[i][1]+maxr+1;
            ds.ubr(u,v);
            s.add(u);
            s.add(v);
        }
        int count=0;
        for(int nod:s)
        {
            if(ds.findulp(nod)==nod)
            count++;

        }
        return stones.length-count;
    }
}
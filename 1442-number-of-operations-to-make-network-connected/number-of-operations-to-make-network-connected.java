class DisjointSet
{
    List<Integer> rank=new ArrayList<>();
    List<Integer> ulp=new ArrayList<>();
    DisjointSet(int n)
    {
     for(int i=0;i<n;i++)
     {
        rank.add(0);
        ulp.add(i);
     }
    }

    int findUP(int node)
    {
        if(ulp.get(node)==node)
        return node;

        int ultimateP=findUP(ulp.get(node));
        ulp.set(node,ultimateP);
        return ultimateP;
    }

    void unionByRank(int n1,int n2)
    {
        int ulp_n1=findUP(n1);
        int ulp_n2=findUP(n2);
        if(ulp.get(n1)==ulp.get(n2))
        return;

        int r_n1=rank.get(ulp_n1);
        int r_n2=rank.get(ulp_n2);

        if(r_n1>r_n2)
        {
            ulp.set(ulp_n2,ulp_n1);
        }
        else if(r_n1<r_n2)
        {
            ulp.set(ulp_n1,ulp_n2);
        }
        else
        {
            ulp.set(ulp_n1,ulp_n2);
            rank.set(ulp_n2,rank.get(ulp_n2)+1);
        }
    }



}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int ex=0;

        for(int i=0;i<connections.length;i++)
        {
            int u=connections[i][0];
            int v=connections[i][1];
            if(ds.findUP(u)==ds.findUP(v))
            ex++;
            else
            ds.unionByRank(u,v);
        }

       int noc=0;
        for(int i=0;i<n;i++)
        {
            if(ds.findUP(i)==i)
            noc++;
        }

        if(ex<noc-1)
        return -1;

        return noc-1;

        

    }
}
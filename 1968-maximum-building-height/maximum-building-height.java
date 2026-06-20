class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> limit=new ArrayList<>();
        limit.add(new int[]{0,0});
        for(int []i:restrictions)
        {
            int node=i[0];
            int res=i[1];
            limit.add(new int[]{node-1,res});
        }
        int last=limit.get(restrictions.length)[0];
        if(last!=n-1)
        {
          limit.add(new int[]{n-1,n-1});
        }

        Collections.sort(limit,(a,b)->a[0]-b[0]);
        for(int i=1;i<limit.size();i++)
        {
            limit.get(i)[1]=Math.min(limit.get(i)[1],limit.get(i)[0]-limit.get(i-1)[0]+limit.get(i-1)[1]);
        }
        for(int i=limit.size()-2;i>=0;i--)
        {
          limit.get(i)[1]=Math.min(limit.get(i)[1],limit.get(i+1)[0]-limit.get(i)[0]+limit.get(i+1)[1]);
        }
        int max=-1;
        for(int i=0;i<limit.size()-1;i++)
        {
            int cur=0;
            int lim1=limit.get(i)[1];
            int lim2=limit.get(i+1)[1];
            int len=limit.get(i+1)[0]-limit.get(i)[0];
            if(lim1>lim2)
            {
                lim2=lim1+lim2;
                lim1=lim2-lim1;
                lim2=lim2-lim1;
            }
            cur=lim2+(len-(lim2-lim1))/2;
            if(cur>max)
            max=cur;
        }
        return max;
    }
}



class Solution {
    public int maxScore(int[] parent, int[] op, int[] score) {
    List<List<Integer>> adj=new ArrayList<>();
    for(int i=0;i<score.length;i++)
    {
        adj.add(new ArrayList<>());
    }
    for(int i=0;i<score.length;i++)
    {
    int node=i;
    int par=parent[i];
    if(par==-1)
    continue;
    else
    adj.get(par).add(node);

    }  
    int n=score.length;
    int sum=dfs(adj,0,score,op);
    return sum;
     
    }
    int dfs(List<List<Integer>> adj,int node,int []score,int op[])
    {
        if(adj.get(node).size()==0)
        {
            return  score[node];
        }
        int min=Integer.MAX_VALUE;
        int cs=score[node];
        for(int i=0;i<adj.get(node).size();i++)
        {
            int res=dfs(adj,adj.get(node).get(i),score,op);
            if(res<min)
            min=res;
            cs+=res;
        }
        if(op[node]==0)
        {
            if(min<0)
            cs=cs-min;
        }
        else
        {
            cs=cs-min;
        }
        return cs;

    }
}
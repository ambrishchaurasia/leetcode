class Solution {
    boolean cycle=false;
    Stack<Integer> stack=new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            int x=prerequisites[i][0];
            int y=prerequisites[i][1];
            adj.get(y).add(x);
        }
        int vis[]=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            if(vis[i]==0)
            dfs(adj,i,vis);
        }
        if(stack.size()>numCourses || cycle)
        return new int[]{};

        int ans[]=new int[numCourses];
        int i=0;
        while(!stack.isEmpty())
        {
            int num=stack.pop();
            ans[i]=num;
            ++i;
        }
        return ans;
    }

   void dfs(List<List<Integer>> adj,int node,int []vis)
    {
        vis[node]=1;

        for(int i=0;i<adj.get(node).size();i++)
        {
            int nei=adj.get(node).get(i);

            if(vis[nei]==1)
            cycle=true;

            if(vis[nei]==0)
            dfs(adj,nei,vis);
        }
        stack.add(node);
        vis[node]=2;
    }
}
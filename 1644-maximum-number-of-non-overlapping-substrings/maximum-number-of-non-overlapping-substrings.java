class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n=s.length();
        int first[]=new int[26];
        int last[]=new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);
        for(int i=0;i<s.length();i++)
        {
            int idx=s.charAt(i)-'a';
            if(first[idx]==-1)
            first[idx]=i;
            last[idx]=i;
        }
        List<int[]> candidates=new ArrayList<>();
        for(int i=0;i<26;i++)
        {
                    Boolean valid=true;

           if(first[i]==-1)
           continue;
           int start=first[i];
           int end=last[i];
           for(int j=start;j<=end;j++)
           {
            int ci=s.charAt(j)-'a';
            if(first[ci]<start)
            {
            valid=false;
            break;
            }
            end=Math.max(end,last[ci]);
           }

           if(valid)
           {
            for(int j=start;j<=end;j++)
            {
                int ci=s.charAt(j)-'a';
            if(first[ci]<start || end<last[ci] )
            {
            valid=false;
            break;
            }
            }
           }
           if(valid)
           {
            candidates.add(new int[]{start,end});
           }
        }

        //remove deuplicates
        candidates.sort((a,b)->a[0]-b[0]);
        List<int[]> uniqueCandidates=new ArrayList<>();
        for(int[]itr:candidates)
        {
            int size=uniqueCandidates.size();
            if(uniqueCandidates.isEmpty() || uniqueCandidates.get(size-1)[0]!=itr[0] ||
            uniqueCandidates.get(size-1)[1]!=itr[1])
            {
                uniqueCandidates.add(itr);
            }
        }
        candidates=uniqueCandidates;
        int m=candidates.size();
        //build graph, we pick all unique start end pair and ceck with other and all overlapping to graph
        List<List<Integer>> adj=new ArrayList<>();
        List<List<Integer>> adjT=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            adj.add(new ArrayList<>());
            adjT.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            int[]a=candidates.get(i);
            for(int j=0;j<m;j++)
            {
                if(i==j)
                continue;
                int []a1=candidates.get(j);

                if(a[0]<a1[0] && a[1]>=a1[0] )
                {
                    adj.get(i).add(j);
                    adjT.get(j).add(i);
                }
            }
        }

    boolean visited[]=new boolean[m];
    Stack<Integer> stack=new Stack<>();
    for(int i=0;i<m;i++)
    {
        if(!visited[i])
        dfs(i,adj,visited,stack);
    }
    Arrays.fill(visited,false);
    List<List<Integer>> sccs=new ArrayList<>();
    while(!stack.isEmpty())
    {
        int node=stack.pop();
        if(!visited[node])
        {
            List<Integer> component=new ArrayList<>();
            dfsT(node,adjT,visited,component);
            sccs.add(component);
        }
    }
    List<int[]> chosen=new ArrayList<>();
    for(List<Integer> comp:sccs)
    {
        int[]best=null;
        for(int index:comp)
        {
            int curr[]=candidates.get(index);
            if(best==null)
            {
                best=curr;
            }
            else
            {
                int lenB=best[1]-best[0];
                int lenC=curr[1]-curr[0];
                if(lenC<lenB)
                {
                    best=curr;
                }
            }
        }
        chosen.add(best);
    }
    chosen.sort((a,b)->Integer.compare(a[1],b[1]));
    List<int[]> resInter=new ArrayList<>();
    int prevEnd=-1;
    for(int []i:chosen)
    {
        if(i[0]>prevEnd)
        {
            resInter.add(i);
            prevEnd=i[1];
        }
    }

    resInter.sort((a,b)->Integer.compare(a[0],b[0]));
List<String> result=new ArrayList<>();
for(int []i:resInter)
{
    result.add(s.substring(i[0],i[1]+1));
}
return result;

    
    }
    void dfs(int node,List<List<Integer>>adj,boolean []visited,Stack<Integer> stack)
    {
        visited[node]=true;
        for(int nei:adj.get(node))
        {
            if(!visited[nei])
            {
                dfs(nei,adj,visited,stack);
            }
        }
        stack.push(node);
    }
        void dfsT(int node,List<List<Integer>>adjT,boolean []visited, List<Integer>component)
    {
        visited[node]=true;
        component.add(node);
        for(int nei:adjT.get(node))
        {
            if(!visited[nei])
            {
                  dfsT(node,adjT,visited,component);
            }
        }
    }
}
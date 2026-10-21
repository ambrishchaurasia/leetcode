class Solution {

    public int findColoredRoot(int[][] edges, String colors) {
        int[]indeg=new int[colors.length()];
        int[]outdeg=new int[colors.length()];
        HashMap<Character,Integer> pair=new HashMap<>();
        pair.put('R',0);
        pair.put('B',1);
        pair.put('W',2);

        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            
            if(colors.charAt(u)==colors.charAt(v))
            return -1;

            else if((pair.get(colors.charAt(u))+1)%3==pair.get(colors.charAt(v)))
            {
                outdeg[u]++;
                indeg[v]++;
            }
            else
            {
                outdeg[v]++;
                indeg[u]++;
            }

        }
        int dup=-1;
        for(int i=0;i<colors.length();i++)
        {
            if(indeg[i]>1)
            return -1;
            if(outdeg[i]>2)
            return -1;
            if(indeg[i]==0)
            {
                if(dup!=-1)
                return -1;
                dup=i;
            }
        }
        return dup;
    }
}
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int c=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int si=0;
        for(int i=0;i<g.length;i++)
        {
            while(si<s.length && s[si]<g[i]  )
            si++;
            if(si==s.length)
            break;
            c++;
            si++;

        }
        return c;
    }
}
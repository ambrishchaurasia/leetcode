class Solution {
    public int maxNumberOfBalloons(String text) {
        int fre[]=new int[26];
        for(char ch:text.toCharArray())
        {
            int idx=ch-'a';
            fre[idx]++;
        }
        char[] match={'b','a','l','o','n'};
        int ans=Integer.MAX_VALUE;
        for(char it:match)
        {
            int f=0;
            int idx=it-'a';
            if(it=='l' || it=='o')
            f=fre[idx]/2;
            else
            f=fre[idx];
            ans=Math.min(f,ans);
        }
        return ans;
    }
}
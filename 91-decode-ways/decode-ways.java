class Solution {
  int dp[];
    public int numDecodings(String s) {
        dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
       int ans= rec(s,0);
        return ans;
    }
    int rec(String s,int i)
    {
        if(i==s.length())
        return 1;

        if(dp[i]!=-1)
        {
            return dp[i];
        }
          int ans=0;
        //1 elemnt
        int e1=s.charAt(i)-'0';
        if(e1>0)
        {
            ans=ans+rec(s,i+1);
        }

        if((i+1)<s.length())
        {
        int e2=Integer.parseInt(s.substring(i,i+2));
        if(e2>=10 && e2<=26)
        {
            ans=ans+rec(s,i+2);
        }
        }

        return dp[i]=ans;
    }
}
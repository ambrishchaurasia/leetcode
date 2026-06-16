class Solution {
    public String processStr(String s) {
        StringBuilder ans=new StringBuilder();
        char []str=s.toCharArray();
        for(char ch:str)
        {
            if(ch=='*')
            {
                int size=ans.length()-1;
                if(size<0)
                continue;
                ans.deleteCharAt(size);

            }
            else if(ch=='#')
            {
                ans.append(ans);
            }
            else if(ch=='%')
            {
                int l=ans.length()-1;
                if(l>=0)
                {
                for(int j=0;j<ans.length()/2;j++)
                {
                    char t=ans.charAt(j);
                    ans.setCharAt(j,ans.charAt(l));
                    ans.setCharAt(l,t);

                    l--;
                }
                }
            }
            else
            ans.append(ch);
        }
        return ans.toString();
    }
}
class Solution {
    public String smallestPalindrome(String s) {
        int fre[]=new int[26];

        if(s.length()<=2)
        return s;

        for(int i=0;i<s.length();i++)
        {
            int n=s.charAt(i)-'a';
            fre[n]++;
        }

        StringBuilder ans=new StringBuilder();
        String left="";
        boolean toggle=false;
        for(int i=0;i<26;i++)
        {
             char ch=(char)(i+97);

            if(fre[i]>1)
            {
                int c=fre[i]/2;

                int rem=fre[i]%2;

                if(rem==1)
                {
                left=left+ch;
                toggle=true;
                }

                for(int j=0;j<c;j++)
                {
                    ans=ans.append(ch);
                }
            }
            else if(fre[i]==1)
            {
                toggle=true;
                left=left+ch;
            }
        }
        String copy=ans.toString();

        if(toggle)
        ans=ans.append(left);

        for(int i=copy.length()-1;i>=0;i--)
        {
            ans=ans.append(copy.charAt(i));
        }
        return ans.toString();

    }
}
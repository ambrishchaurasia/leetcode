class Solution {
    public int minOperations(String s1, String s2) {
        char []str1=s1.toCharArray();
        char []str2=s2.toCharArray();
        if(str1.length==1)
        {
            if(str1[0]==str2[0])
            return 0;
            else if(str1[0]=='0'&&str2[0]=='1')
            return 1;
            else
            return -1;
        }
        int ans=0;
        for(int i=0;i<str1.length;i++)
        {
            if(str1[i]==str2[i])
            continue;

            else if(str1[i]=='0' && str2[i]=='1')
            {
            str1[i]='1';
            ans++;
            }

            else if(str1[i]=='1' && str2[i]=='0')
            {
                if(i+1<str1.length && str1[i+1]=='1')
                {
                ans++;
                str1[i+1]='0';
                str1[i]='0';
                }

                else if(i+1<str1.length && str1[i+1]=='0')
                {
                ans=ans+2;
                str1[i]='0';
                }
                else if(i-1>=0)
                {
                    ans=ans+2;
                    str1[i]='0';
                }

            }
        }
        return ans;
    }
}
class Solution {
    public char processStr(String s, long k) {
        long l=0;

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='#')
            {
                l=l*2;
            }
            else if(ch=='%')
            {
                
            }
            else if(ch=='*')
            {
                if(l>0)
                l--;
            }
            else
            l++;
        }

        if(l<=k)
        return '.';

        for(int i=s.length()-1;i>=0;i--)
        {
          if(s.charAt(i)=='*')
          l++;
          else if(s.charAt(i)=='#')
          {
            l=l/2;
            if(k>=l)
            k=k-l;
          }
          else if(s.charAt(i)=='%')
          {
            k=l-k-1;
          }
          else
          {
          l--;
          
          if(k==l)
          return s.charAt(i);
                    }
          
        }
        return '.';
    }
}
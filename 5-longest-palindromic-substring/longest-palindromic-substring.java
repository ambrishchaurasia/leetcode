class Solution {
    public String longestPalindrome(String s) {
        int maxs=-1;
        int maxe=-4;
        if(s.length()==1)
        return s;


        for(int i=0;i<s.length();i++)
        {  
            int st=i;
            int en=i;

            StringBuilder ans=new StringBuilder();
            //odd
            while(st>=0 && (en<=s.length()-1) && s.charAt(st)==s.charAt(en))
            {
                if(en-st+1>maxe-maxs+1)
                {
                 maxe=en;
                 maxs=st;
                }
                st--;
                en++;
            }
             
            st=i;
            en=i+1;            
            //even
            while(st>=0 && en<=s.length()-1 && s.charAt(st)==s.charAt(en))
            {
               
               if(en-st+1>maxe-maxs+1)
                {
                 maxe=en;
                 maxs=st;
                }
                st--;
                en++;

            }

        }
        return s.substring(maxs,maxe+1);
    }
}
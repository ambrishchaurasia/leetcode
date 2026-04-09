class Solution {
    public String longestPalindrome(String s) {
        StringBuilder answer=new StringBuilder();

        for(int i=0;i<s.length();i++)
        {

            
            int st=i;
            int en=i;
            StringBuilder ans=new StringBuilder();

            
            //odd
            while(st>=0 && (en<=s.length()-1) && s.charAt(st)==s.charAt(en))
            {
                if(st!=en)
                {
                ans.insert(0,s.charAt(st));
                ans.append(s.charAt(en));
                }
                else
                {
                    ans.append(s.charAt(i));
                }
                    
                if(ans.length()>answer.length())
                {
                 String t=ans.toString();
                 answer.setLength(0); 
                 answer.append(t);  
                }
                st--;
                en++;

            }

            st=i;
            en=i+1;
            ans.setLength(0);   

            
            //even
            while(st>=0 && en<=s.length()-1 && s.charAt(st)==s.charAt(en))
            {
                ans.insert(0,s.charAt(st));
                ans.append(s.charAt(en));

                if((en-st+1)>answer.length())
                {
                 String t=ans.toString();
                 answer.setLength(0); 
                 answer.append(t);  

                }
                st--;
                en++;

            }

        }
        return answer.toString();
    }
}
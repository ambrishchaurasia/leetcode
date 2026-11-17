class Solution {
    public String digitSum(String s, int k) {
        
        while(s.length()>k)
        {
            StringBuilder st=new StringBuilder();
            int c=0;
            int sum=0;

            for(int i=0;i<s.length();i++)
            {
                ++c;
                sum+=(int)(s.charAt(i)-'0');

                if(c==k)
                {
                    st.append(Integer.toString(sum));
                    c=0;
                    sum=0;
                }
                else if(i==s.length()-1)
                {
                   st.append(Integer.toString(sum));

                }
            }
            s=st.toString();

        }
        return s;
    }
}
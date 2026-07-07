class Solution {
    public long sumAndMultiply(int n) {
        int sum=0;
        int ans=0;
        int mod=1000000000;
            String num=Integer.toString(n);
            for(int i=0;i<num.length();i++)
            {
                char number=num.charAt(i);
                if(number!='0')
                {
                    sum=sum+number-'0';
                    ans=ans*10+number-'0';
                }
            }
            return (1L * sum*ans);
    }
}
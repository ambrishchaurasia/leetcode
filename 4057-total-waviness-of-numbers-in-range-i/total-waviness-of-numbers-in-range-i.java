class Solution {
    public int totalWaviness(int num1, int num2) {
        if(num1<100 && num2<100 )
        return 0;

        while(num1<100)
        num1++;
        int ans=0;

        for(int i=num1;i<=num2;i++)
        {
            String num=Integer.toString(i);
            for(int j=1;j<num.length()-1;j++)
            {
                int prev=num.charAt(j-1)-'0';
                int next=num.charAt(j+1)-'0';
                int curr=num.charAt(j)-'0';
                if(curr> prev && curr>next)
                ans++;
                else if(curr<prev && curr<next)
                ans++;
            }
        }
        return ans;
    }
}
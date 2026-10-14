class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans=new StringBuilder();
        int counter =0;
        while(counter<num)
        {
            if(sum<=9)
            {
                int idx=(int)sum+'0';
                char ap=(char)idx;
                ans.append(ap);
                sum=0;
            }
            else
            { 
                ans.append('9');
                sum=sum-9;
            }
            counter++;
        }
        if(sum>0)
        return "";
        return ans.toString();
    }
}
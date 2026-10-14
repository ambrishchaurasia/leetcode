class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans=new StringBuilder();
        int counter =0;
        while(counter<num)
        {
            if(sum<=9)
            {
                ans.append( Integer.toString(sum));
                sum=0;
            }
            else
            {
                int cur=9;
                ans.append(Integer.toString(cur));
                sum=sum-9;
            }
            counter++;
        }
        if(sum>0)
        return "";
        return ans.toString();
    }
}
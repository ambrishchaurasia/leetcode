class Solution {
    int dp[][];
            int ans=0;

    public int maximalSquare(char[][] matrix) {
        dp=new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]=='1')
                {
                    rec(i,j,matrix);
                    
                }
            }
        }
        return ans;
    }
    int rec(int i,int j,char[][]matrix)
    {
        if(i>=matrix.length)
        return 0;
        if(j>=matrix[0].length)
        return 0;
        if(matrix[i][j]=='0')
        return 0;
        
        if(dp[i][j]!=-1)
        return dp[i][j];
        int r=rec(i,j+1,matrix);

        int d=rec(i+1,j,matrix);

        int dia=rec(i+1,j+1,matrix);
        int cur=1+ Math.min(dia,Math.min(r,d));
        int area=cur*cur;
        if(area>ans)
        ans=area;
        return dp[i][j]=cur;
    }
}
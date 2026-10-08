class Solution {
    int dp[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        int n=obstacleGrid.length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1)
        return 0;
        for(int i=0;i<obstacleGrid.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return rec(0,0,obstacleGrid);
    }
    int rec(int x,int y,int[][]obstacleGrid)
    {
        if(x==obstacleGrid.length-1 && y==obstacleGrid[0].length-1)
        {
           return 1;
        }
        if(dp[x][y]!=-1)
        {
            return dp[x][y];
        }
        int down=0;
        if(x+1<obstacleGrid.length && obstacleGrid[x+1][y]!=1)
        down=rec(x+1,y,obstacleGrid);
        int right=0;
        if(y+1<obstacleGrid[0].length && obstacleGrid[x][y+1]!=1)
        right=rec(x,y+1,obstacleGrid);
        return dp[x][y]=down+right;
    }
}
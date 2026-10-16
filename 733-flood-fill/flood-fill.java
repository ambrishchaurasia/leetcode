class Solution {
    boolean visited[][]=new boolean[51][51];
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        visited[sr][sc]=true;
        int row[]={0,-1,0,1};
        int col[]={-1,0,1,0};
        int c=image[sr][sc];
        image[sr][sc]=color;
        
        for(int i=0;i<4;i++)
        {
        int sr1=sr+row[i];
        int sc1=sc+col[i];
       if(sr1>=0 && sc1>=0 && sr1<image.length && sc1<image[0].length && image[sr1][sc1]==c && !visited[sr1][sc1])
       {
       floodFill(image,sr1,sc1,color);
       }
        }
        return image;
    }
}
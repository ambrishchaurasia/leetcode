class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                queue.offer(new int[]{i,j});
                else
                mat[i][j]=Integer.MAX_VALUE;
            }
        }
        int m=mat[0].length;

        while(!queue.isEmpty())
        {

            int a[]=queue.poll();
            int x=a[0];
            int y=a[1];

            Queue<int[]> q=new LinkedList<>();
            q.offer(new int[]{x,y});
            int row[]={0,-1,0,1};
            int col[]={-1,0,1,0};

                            int counter=1;


            while(!q.isEmpty())
            {
                  int n=q.size();
                for(int k=0;k<n;k++)
                {
                int a1[]=q.poll();
                int x1=a1[0];
                int y1=a1[1];


                for(int i=0;i<4;i++)
                {
                    int nx=x1+row[i];
                    int ny=y1+col[i];

                    if(nx>=0 && ny>=0 && nx<mat.length && ny<mat[0].length)
                    {
                        if(mat[nx][ny]!=0 && mat[nx][ny]>counter)
                        {
                        mat[nx][ny]=counter;
                        q.offer(new int[]{nx, ny});
                        }
                    }
                }
                }
                                counter++;

            }

        }
        return mat;

    }
}
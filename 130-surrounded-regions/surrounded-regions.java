class Solution {
    public void solve(char[][] board) {
        Queue <int[]> queue=new LinkedList<>();
                boolean vis[][]=new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='O' && (i==0 || j==0 || i==board.length-1 || j==board[0].length-1))
                {
                    board[i][j]='M';
                    queue.offer(new int[]{i,j});
                    vis[i][j]=true;
                }
            }
        }
        int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};
        while(!queue.isEmpty())
        {
            int a[]=queue.poll();
            int x=a[0];
            int y=a[1];
            for(int i=0;i<4;i++)
            {
                int cx=a[0]+row[i];
                int cy=a[1]+col[i];
                
                if(cx>=0 && cy>=0 && cx<board.length && cy<board[0].length && board[cx][cy]=='O' && !vis[cx][cy])
                {
                    board[cx][cy]='M';
                    queue.offer(new int[]{cx,cy});
                    vis[cx][cy]=true;
                }
                
            }

        }

        
           for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='M')
                {
                    board[i][j]='O';
                }
                else if(board[i][j]=='O')
                board[i][j]='X';
            }
        }
    }
}
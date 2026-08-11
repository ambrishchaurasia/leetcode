class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int u=0;
        int l=0;
        int d=n-1;
        List<Integer> ans=new ArrayList<>();
        int r=m-1;
        while(l<=r && u<=d)
        {
            int i1=l;
            //left to right
            while(l<=r && u<=d && i1<=r)
            {
                ans.add(matrix[u][i1]);
                i1++;
                i++;
            }
            u++;

            //up to down
            int i2=u;
            while(l<=r && u<=d && i2<=d)
            {
                ans.add(matrix[i2][r]);
                i2++;
                i++;
            }
            r--;

            //right to left
            int i3=r;
            while(l<=r && u<=d && i3>=l)
            {
                ans.add(matrix[d][i3]);
                i3--;
                i++;
            }
            d--;

            int i4=d;
            while(l<=r && u<=d && i4>=u)
            {
                ans.add(matrix[i4][l]);
                i4--;
                i++;
            }
            l++;
        }
        return ans;
    }
}
class Solution {
    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //build list
        int a[][]=new int [n][n];
      
       for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                 if(i==j)
                a[i][j]=0;
                else
                a[i][j]=Integer.MAX_VALUE;
               
            }
        }
        for(int i=0;i<edges.length;i++)
        {
                int node=edges[i][0];
                int neighbour=edges[i][1];
                int wt=edges[i][2];
                a[node][neighbour]=wt;
                a[neighbour][node]=wt;
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(j==i || k==i)
                    continue;

                    if(a[j][i]!=Integer.MAX_VALUE && a[i][k]!=Integer.MAX_VALUE)
                    {
                    if(a[j][k]>a[j][i]+a[i][k])
                    a[j][k]=a[j][i]+a[i][k];
                    }
                }
            }
        }

        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i][j]<=distanceThreshold)
                arr[i]++;
            }
        }

        int max=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<n;i++)
        {
            if(arr[i]<=max)
            {
            max=arr[i];
            ans=i;
            }
        }
        return ans;
    }
}
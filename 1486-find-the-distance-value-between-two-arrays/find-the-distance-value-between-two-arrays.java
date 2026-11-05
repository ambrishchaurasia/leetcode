class Solution {
    int bs(int arr[],int x)
    {
        if(arr.length==1)
        return arr[0];

        int l=0;
        int r=arr.length-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(arr[mid]==x)
            return arr[mid];
            else if(arr[mid]<x)
            l++;
            else
            r--;
        }
        if(r<0)
        {
            System.out.println(arr[l]);
        return arr[l];
        }
        else if(l>=arr.length)
        {
            System.out.println(arr[r]);

        return arr[r];
        }
        else 
        {
          int dif1=x-arr[r];
          int dif2=arr[l]-x;
          if(dif1>dif2)
          {
                        System.out.println(arr[l]);

          return arr[l];
          }

          else
        {
         System.out.println(arr[r]);

          return arr[r];
        }
        }
    }
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans=0;
        for(int i:arr1)
        {
            if(Math.abs(i-bs(arr2,i))<=d)
            {

            }
            else
            {
                ++ans;
            }
        }
        return ans;
    }
}
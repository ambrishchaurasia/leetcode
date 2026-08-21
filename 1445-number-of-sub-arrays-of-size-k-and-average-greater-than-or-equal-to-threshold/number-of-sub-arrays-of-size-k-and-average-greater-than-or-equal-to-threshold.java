class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l=0;
        int r=0;
        int curr=0;
        int ans=0;
        while(r<arr.length)
        {
            
            curr=curr+arr[r];
         
            if(r-l+1==k && threshold<=((1.0*curr)/k))
            {
                ans++;
                System.out.print(r);
                curr=curr-arr[l];
                 l++;


            }
            else if(r-l+1==k && threshold>(1.0*curr/k))
            {
                 curr=curr-arr[l];
                l++;
                
               
            }
               r++;
        }
        return ans;
    }
}
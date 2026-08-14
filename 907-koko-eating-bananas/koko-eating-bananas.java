class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int mx=-1;
        for(int i=0;i<piles.length;i++)
        {
            if(piles[i]>mx)
            mx=piles[i];
        }
        int r=mx;
        while(l<r)
        {
            int mid=l+(r-l)/2;
         
            if(isValid(piles,h,mid))
            {
                r=mid;
            }
            else
            {
                l=mid+1;
            }
        }
        return l;
    }

    boolean isValid(int[] piles, int h,int k)
    {
        
        for(int i=0;i<piles.length;i++)
        {
            if(piles[i]<k)
            h--;

            else if(piles[i]%k==0)
            h=h-(piles[i]/k);

            else if(piles[i]%k!=0)
            h=h-(piles[i]/k)-1;

            if(h<0)
            return false;
        }
        if(h>=0)
        return true;

        return false;
    }
}
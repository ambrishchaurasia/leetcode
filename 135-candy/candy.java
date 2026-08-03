class Solution {
    public int candy(int[] ratings) {
        int i=0;
        int ans=0;
        int peak=1;
        int peak2=1;
        while(i<ratings.length-1)
        {
            

             while(i<ratings.length-1 && ratings[i]==ratings[i+1])
            {
                ans=ans+1;
                i++;
            }

            peak= 1;
            while(i<ratings.length-1  && ratings[i]<ratings[i+1])
            {
                ans=ans+peak;
                peak++;
                i++;
            }
           
            peak2=1;
            while(i<ratings.length-1 && ratings[i]>ratings[i+1])
            {
                ans=ans+peak2;
                peak2++;
                i++;
            }
            ans=ans+Math.max(peak,peak2)-1;
           
        }
        return ans+1;
    }
}
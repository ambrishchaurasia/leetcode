class Solution {
    public int candy(int[] ratings) {
        int l[]=new int[ratings.length];
        l[0]=1;
         for(int i=1;i<ratings.length;i++)
         {
            if(ratings[i-1]<ratings[i])
            {
                l[i]=l[i-1]+1;
            }
            else
            l[i]=1;
         }

         int curr=0;
         int right=0;
         right=1;
         int sum=0;
        sum=sum+l[ratings.length-1];

        for(int i=ratings.length-2;i>=0;i--)
         {
            if(ratings[i]>ratings[i+1])
            {
                curr=1+right;
                right=curr;
            }
            else{
            right=1;
            curr=1;
            }

            sum=sum+Math.max(l[i],curr);
         }
         return sum;

    }
}
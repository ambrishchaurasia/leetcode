//slope approach
class Solution {
    public int candy(int[] ratings) {
        int down;
        int peak;
        int sum=1;
        int i=1;
        if(ratings.length==1)
        return 1;
        boolean p=false;
        while(i<ratings.length)
        {
            while(i<ratings.length && ratings[i]==ratings[i-1])
            {

                sum=sum+1;
                i++;
            }
            peak=1;
          while(i<ratings.length && ratings[i-1]<ratings[i])
          {
             p=true;
            i++;
            peak++;
            sum=sum+peak;
          }
          down=0;
          while(i<ratings.length &&  ratings[i-1]>ratings[i])
          {
            i++;
            down++;
            sum=sum+down;
          }
          down++;
          if(peak<down )
          {
            sum=sum+down-peak;
          }
        }
        return sum;
    }
}
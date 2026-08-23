class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int l=0;
        int r=0;
            int sum=0;
           while(r-l+1<=k)
            {
               sum+=nums[r];
               r++;
            }

            double max=(1.0* sum)/(1.0*k);
            sum=sum-nums[l];
            l++;
            

        while(r<nums.length)
        {
              sum+=nums[r];
               double avg=(1.0* sum)/(1.0*k);
                if(avg>max )
                max=avg;
                r++;
                sum=sum-nums[l];
                l++;
        }
                return max;

        }
    }

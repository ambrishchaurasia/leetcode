//binary serach
class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(nums.length==1 || nums[0]>nums[1])
        {
            return 0;
        }
        if(nums[n-1]>nums[n-2])
        {
            return n-1;
        }

        int l=1;
        int r=nums.length-1;
        while(l<=r)
        {
          int mid=l+((r-l)/2);
          if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
          {
            return mid;
          }
          else if(nums[mid]>nums[mid-1])
          {
            l=mid+1;
          }
          else
          {
            r=mid-1;
          }
        }
        return -1;
    }
}
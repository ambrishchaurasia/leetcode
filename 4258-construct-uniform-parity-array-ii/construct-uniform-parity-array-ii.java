class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=Integer.MAX_VALUE;
        int o=0;
        int e=0;
        for(int i=0;i<nums1.length;i++)
        {
            if(min>nums1[i])
            min=nums1[i];

            if(nums1[i]%2==0)
            e++;
            if(nums1[i]%2!=0)
            o++;
        }

        if(min%2==0 )
        {
            if(e==nums1.length)
            return true;
            return false;
        }
        if(min%2!=0 )
        {
            return true;
        }
        return false;
    }
}
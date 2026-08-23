class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int i=0;
       int j=0;
       List<Integer> med=new ArrayList<>();
       while(i<nums1.length && j<nums2.length)
       {
        if(nums1[i]<nums2[j])
        {
            med.add(nums1[i]);
            i++;
        }
        else
        {
            med.add(nums2[j]);
            j++;
        }
       }

       while(i<nums1.length)
       {
        med.add(nums1[i]);
        i++;
       }

       while(j<nums2.length)
       {
        med.add(nums2[j]);
        j++;
       }

       if(med.size()%2!=0)
       {
        return med.get(med.size()/2);
       }
       else
       {
        int x=med.get(med.size()/2);
        int y=med.get((med.size()/2)-1);
        return 1.0*(x+y)/2.0;
       }

    }
}
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int ans=intervals.length;
        int indextocomp=0;
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[indextocomp][1]>=intervals[i][1])
            {
              ans--;
            }
            else
            {
                  if(intervals[indextocomp][0]==intervals[i][0])
                {
                    ans--;
                }
                indextocomp=i;
            }
            
        }
        return ans;
    }
}
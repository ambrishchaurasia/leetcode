class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> ans=new ArrayList<>();
        for(int i=0;i<intervals.length;i++)
        {
            if(ans.isEmpty() || ans.get(ans.size()-1)[1]>=intervals[i][0])
            {
                int left=intervals[i][0];
                int right=intervals[i][1];

                if(ans.isEmpty())
                {
                ans.add(new int[]{left,right});
                }
                else
                {
                left=ans.get(ans.size()-1)[0];
                right= ans.get(ans.size()-1)[1];
                ans.get(ans.size()-1)[1]=Math.max(right,intervals[i][1]);
                }  
            }
            else
            {
                ans.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }
        int[][] a=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++)
        {
            a[i][0]=ans.get(i)[0];
            a[i][1]=ans.get(i)[1];
        }
        return a;
    }
}
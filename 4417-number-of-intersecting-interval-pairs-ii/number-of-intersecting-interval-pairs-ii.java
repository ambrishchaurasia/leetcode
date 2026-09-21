class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        long ans=0;
        PriorityQueue<Integer> pq =new PriorityQueue<>((a,b)->a-b);
        for(int i=0;i<intervals.length;i++)
        {
            while(!pq.isEmpty() && pq.peek()<intervals[i][0])
            {
                pq.poll();
            }
            ans+=pq.size();
            pq.offer(intervals[i][1]);
        }
        return ans;
    }
}
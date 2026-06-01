class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int i=cost.length-1;
        int sum=0;
        if(cost.length==1)
        return cost[0];
        while(i>=0)
        {
        
            sum+=cost[i--];
            if(i>=0)
            sum+=cost[i--];
            i--;
        }
        return sum;
    }
}
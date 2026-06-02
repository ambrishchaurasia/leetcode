class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++)
        {
            int et=landStartTime[i]+landDuration[i];
            if(et<min)
            min=et;
        }
        int st=0;
        int wmin=Integer.MAX_VALUE;
        for(int i=0;i<waterStartTime.length;i++)
        {
            
            if(waterStartTime[i]<min)
            st=min;
            else
            st=waterStartTime[i];
            int et=st+waterDuration[i];
            if(et<wmin)
            wmin=et;
        }

        //case 2
            int min2=Integer.MAX_VALUE;
          for(int i=0;i<waterStartTime.length;i++)
        {
            int et2=waterStartTime[i]+waterDuration[i];
            if(et2<min2)
            min2=et2;
        }

           int st2=0;
        int lmin=Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++)
        {
            
            if(landStartTime[i]<min2)
            st2=min2;
            else
            st2=landStartTime[i];
            
            int et=st2+landDuration[i];
            if(et<lmin)
            lmin=et;
        }

        return wmin<lmin?wmin:lmin;
    }
}
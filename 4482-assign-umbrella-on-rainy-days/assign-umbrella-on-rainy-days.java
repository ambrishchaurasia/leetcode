class Solution {
    public String[] assignUmbrella(int[] rain) {
        int al=0;
        int bo=0;
        int idx=0;
        String ans[]=new String[rain.length];
        for(int i=0;i<rain.length;i++)
        {
            if(rain[i]==0)
            {
                ans[idx]="None";
            }
            else{
                //both needs
                if(i+1<rain.length && rain[i+1]==1)
                {
                    if(al<=bo)
                    {
                        ans[idx]="Alice";
                        al++;
                    }
                    else if(al>bo)
                    {
                        ans[idx]="Bob";
                        bo++;
                    }
                }
                //bob needs it
                else
                {
                    ans[idx]="Bob";
                    bo++;
                }
            }
            idx++;
        }
        return ans;
    }
}
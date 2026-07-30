class Solution {
    public int minimumPushes(String word) {
        char w[]=word.toCharArray();
        int ans=0;
        for(int i=0;i<w.length;i++)
        {
            if(i>=0 && i<=7)
            {
            ans++;
            }

            else if(i>=8 && i<=15)
            ans=ans+2;

            else if(i>=16 && i<=23)
            ans=ans+3;

            else 
            ans=ans+4;
        }
        return ans;
    }
}
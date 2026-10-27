class Solution {
    public int calculateScore(int a, int b) {
        int c1=0;
        while(a!=0)
        {
            int cur=a&1;
            if(cur==1)
            {
                c1++;
            }
            a=a>>1;
        }
          int c2=0;
        while(b!=0)
        {
            int cur=b&1;
            if(cur==1)
            {
                c2++;
            }
            b=b>>1;
        }
        if(c1>=c2)
        return c1*c2;
        else
        return c2/c1;

    }
}
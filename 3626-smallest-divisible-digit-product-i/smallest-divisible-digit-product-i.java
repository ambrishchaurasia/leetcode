class Solution {
    public int smallestNumber(int n, int t) {
        if(n==100)
        return 100;

        int i=n;
        int first=n/10;
        int mul=first+1;

        if(i%10!=0)
        {
        while(i%10 !=0)
        {
            int c=i;
            int pro=1;
            while(c!=0)
            {
                int x=c%10;
                pro=pro*x;
                c=c/10;
            }
            if(pro%t==0)
            return i;

            i++;
        }
        }
        else
        mul=first;

        int sec=0;
        while(i>=0 && i<=100)
        {
            if(sec==10)
            {
                mul++;
                sec=0;
            }
            int pro=mul*sec;
            if(pro%t==0)
            return mul*10+sec;
            sec++;
        }
        return 0;
    }
}
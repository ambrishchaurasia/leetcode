class Solution {
    public boolean checkDivisibility(int n) {
        int pro=1;
        int sum=0;
        int nc=n;
        while(n!=0)
        {
            int x=n%10;
            pro=pro*x;
            sum=sum+x;
            n=n/10;
        }
        return nc%(pro+sum)==0;
    }
}
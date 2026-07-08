class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return fastPow(x, N);
    }
    
     double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        if(n<0)
        {
            return fastPow(1.0/x,-1*n);
        }
        if (n % 2 == 0) {
            return fastPow(x*x,n/2);
        } 
        else {
            return x*fastPow(x*x,n/2);
        }
    }
}

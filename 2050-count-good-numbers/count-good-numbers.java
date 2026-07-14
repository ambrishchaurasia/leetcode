class Solution {
            int mod=1000000007;

    public int countGoodNumbers(long n) {
        long even= ((n+1)/2);
        long odd=(n/2);
        int ans=(int) ( ( (pow(5,even)) * (pow(4,odd)) ) %mod);
        return ans;
    }
    long pow(long num,long power)
    {
        if(power==0)
        return 1;

        if(power%2==0)
        return pow((num*num)%mod,power/2);
        else
        return (num*pow((num*num)%mod,power/2))%mod;
    }
    
}
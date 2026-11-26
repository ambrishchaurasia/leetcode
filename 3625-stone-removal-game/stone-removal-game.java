class Solution {
    public boolean canAliceWin(int n) {
        int val=10;
        while(n>0)
        {
            if(n<val)
            {
                return val%2==0?false:true;
            }
            n=n-val;
            val--;
        }
        return val%2==0?false:true;
    }
}
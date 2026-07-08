class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int[] sum=new int[s.length()];
        int []num=new int[s.length()];
        int nonzero[]=new int[s.length()];

        int mod=1000000007;
        char ch=s.charAt(0);
       
        int K=0;

        if(ch!='0')
        {
            sum[0]=ch-'0';
            num[0]=ch-'0';
            K++;
            nonzero[0]=1;
        }
    
        
        for(int i=1;i<s.length();i++)
        {
            int curnum=s.charAt(i)-'0';
            if(s.charAt(i)!='0')
            {
                num[i]=(int) ((1L* num[i-1]*10+curnum)%mod);
                sum[i]=sum[i-1]+curnum;
                nonzero[i]=nonzero[i-1]+1;
                K++;
            }
            else
            {
                sum[i]=sum[i-1];
                nonzero[i]=nonzero[i-1];
                num[i]=num[i-1];
            }
        }

        int pow[]=new int[K+1];
        int power=1;
        for(int i=0;i<pow.length;i++)
        {
            pow[i]=power;
            power=(int) ((1L *power*10)%mod);
        }

        int []ans=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            int l=queries[i][0];
            int r=queries[i][1];
            int lnum=0;
            int lsum=0;
            int lnonzero=0;
            if(l-1>=0)
            {
            lnum=num[l-1];
            lsum=sum[l-1];
            lnonzero=nonzero[l-1];
            }
            int k=nonzero[r]-lnonzero;
            int current=(int) ((num[r]-1L*lnum*pow[k])%mod);
            if(current<0)
            current=current+mod;
            int cursum=sum[r]-lsum;
            ans[i]=(int)((1L* current * cursum)%mod);

        }
        return ans;
    }
}
class Solution {
    public List<Integer> maxPrimes(int n, int s) {
         List<Integer> prime=sieve(n);
         List<Integer> ans=new ArrayList<>();
         int sum=0;
         for(int i=0;i<prime.size();i++)
         {
           if( sum+prime.get(i)>s)
           break;
           sum+=prime.get(i);
           ans.add(prime.get(i));
         }
         return ans;
    }
    List<Integer> sieve(int n)
    {
        boolean p[]=new boolean[n+1];
        p[1]=true;
        p[0]=true;
        for(int i=2;i*i<=n;i++)
        {
            for(int j=2;j*i<=n;j++)
            {
                int num=i*j;
                p[num]=true;
            }
        }
     List<Integer> ans=new ArrayList<>();
        for(int i=2;i<=n;i++)
        {
            if(!p[i])
            ans.add(i);  
        }
        return ans;
    }
}
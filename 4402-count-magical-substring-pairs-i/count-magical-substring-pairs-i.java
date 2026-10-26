class Solution {
    public int countMagicalPairs(String s) {
        int ans=0;
        for(int j=0;j<s.length();j++)
        {
            int i=j;
            int k=j+1;
            HashMap<Integer,Integer> hm1=new HashMap<>();
            HashSet<Character> hs1=new HashSet();
            HashMap<Integer,Integer> hm2=new HashMap<>();
            HashSet<Character> hs2=new HashSet();

            while(i>=0)
            {
                hs1.add(s.charAt(i));
                hm1.put(hs1.size(),hm1.getOrDefault(hs1.size(),0)+1);
                i--;
            }

            while(k<s.length())
            {
                hs2.add(s.charAt(k));
                hm2.put(hs2.size(),hm2.getOrDefault(hs2.size(),0)+1);
                k++;
            }

            int n=hm1.size();
            int n1=hm2.size();

            if(n>n1)
            {
                for(Map.Entry<Integer,Integer> a:hm1.entrySet())
                {
                    int x=a.getKey();
                    int fre=a.getValue();
                    int fre2=hm2.getOrDefault(x,0);

                    ans+=fre*fre2;
                }
            }
            else
            {
                 for(Map.Entry<Integer,Integer> a:hm2.entrySet())
                {
                    int x=a.getKey();
                    int fre=a.getValue();

                    int fre2=hm1.getOrDefault(x,0);
                    ans+=fre*fre2;
                   
                }
            }

        }
        return ans;
    }
}
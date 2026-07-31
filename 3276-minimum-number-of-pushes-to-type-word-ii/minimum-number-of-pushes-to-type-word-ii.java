class Solution {
    public int minimumPushes(String word) {
        int val[]=new int[26];
        HashMap<Character,Integer> hm=new HashMap<>();
        int c=0;
        int ans=0;
        for(int i=0;i<word.length();i++)
        {
            char w=word.charAt(i);
            hm.put(w,hm.getOrDefault(w,0)+1);
        }
        List< Map.Entry<Character,Integer>> hma=new ArrayList<>(hm.entrySet());
        Collections.sort(hma,(a,b)->b.getValue()-a.getValue());
        for(Map.Entry<Character,Integer> ch:hma)
        {
            int idx=ch.getKey()-'a';
            int fre=ch.getValue();
            if(val[idx]==0)
            {
                c++;
                if(c>=1 && c<=8)
                {
                    val[idx]=1;
                }
                else if(c>=9 && c<=16)
                {

                    val[idx]=2;
                }
                else if(c>=17 && c<=24)
                {
                    val[idx]=3;
                }
                else
                {
                    val[idx]=4;
                }
                
            }
            ans=ans+fre*val[idx];
            
        }
        return ans;
    }
}
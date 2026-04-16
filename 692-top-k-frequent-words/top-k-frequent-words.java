class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap <String,Integer> hm=new HashMap<>();
         for(int i=0;i<words.length;i++)
         {
            int f=hm.getOrDefault(words[i],0);
            hm.put(words[i],f+1);
         }
         ArrayList<Map.Entry<String,Integer>> arr=new ArrayList<>(hm.entrySet());
         Collections.sort(arr,(a,b)->
         {
            if(b.getValue()!=a.getValue())
            return b.getValue()-a.getValue();
            else
            return (a.getKey()).compareTo(b.getKey());
         });

            int c=0;
            List<String> ans=new ArrayList<>();
         for(Map.Entry<String,Integer> a:arr)
         {
         ans.add(a.getKey());
         c++;
         if(c==k)
         break;
         }
            return ans;
    }
}
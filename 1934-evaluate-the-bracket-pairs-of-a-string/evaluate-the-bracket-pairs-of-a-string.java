class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> hm=new HashMap<>();
        for(List<String> it:knowledge)
        {
            String key=it.get(0);
            String val=it.get(1);
            hm.put(key,val);

        }
        StringBuilder ans=new StringBuilder();
        int i=0;
        while(i<s.length())
        {
            while(i<s.length() && s.charAt(i)!='(')
            {
                ans.append(s.charAt(i));
               i++;

            }

            if(i<s.length() && s.charAt(i)=='(')
            {
                StringBuilder key=new StringBuilder();
                i++;
            while(s.charAt(i)!=')')
            {
            key.append(s.charAt(i));
            i++;
            }
            String k=key.toString();
            if(hm.containsKey(k))
            ans.append(hm.get(k));
            else
            ans=ans.append("?");
             i++;
         }   
        }

        return ans.toString();
    }
}
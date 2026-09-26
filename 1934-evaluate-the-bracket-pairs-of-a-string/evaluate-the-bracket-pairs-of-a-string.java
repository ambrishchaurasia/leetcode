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
                String key="";
                i++;
            while(s.charAt(i)!=')')
            {
                key=key+s.charAt(i);
            i++;
            }
            System.out.print(key);
            if(hm.containsKey(key))
            ans.append(hm.get(key));
            else
            ans=ans.append("?");
             i++;
         }   
        }

        return ans.toString();
    }
}
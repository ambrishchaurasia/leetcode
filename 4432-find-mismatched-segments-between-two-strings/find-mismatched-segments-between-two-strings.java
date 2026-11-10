class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> ans=new ArrayList<>();
        int i=0;
        while(i<s1.length())
        {
            String a1="";
            String a2="";
            boolean added=false;
            while(i<s1.length()&&(s1.charAt(i)!=s2.charAt(i)))
            {
                a1=a1+s1.charAt(i);
                a2=a2+s2.charAt(i);
                added=true;
                ++i;
            }

            if(added)
            {
                ans.add(Arrays.asList(a1,a2));
            }
            ++i;

        }
        return ans;
    }
}
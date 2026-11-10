class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> ans=new ArrayList<>();
        int i=0;
        while(i<s1.length())
        {
            StringBuilder a1=new StringBuilder();
            StringBuilder a2=new StringBuilder();
            boolean added=false;
            while(i<s1.length()&&(s1.charAt(i)!=s2.charAt(i)))
            {
                a1.append(s1.charAt(i));
                a2.append(s2.charAt(i));
                added=true;
                ++i;
            }

            if(added)
            {
                ans.add(Arrays.asList(a1.toString(),a2.toString()));
            }
            ++i;

        }
        return ans;
    }
}
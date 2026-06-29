class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count=0;
        for(String str:patterns)
        {
            if(isSubstring(str,word))
            count++;
        }
        return count;
    }
    boolean isSubstring(String str,String word)
    {
        int i=0;
        int j=0;
        int start=0;
        if(str.length()>word.length())
        return false;
        while(i<word.length() && j<str.length())
        {
            start=i;
            while(i<word.length() && j<str.length() && word.charAt(i)==str.charAt(j))
            {
                i++;
                j++;
            }
            if(j==str.length())
            {
            return true;
            }
            i=start+1;
            j=0;

        }
        return false;
    }
}
class Solution {
    public boolean checkString(String s) {
        boolean a=false;
        boolean b=false;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a')
            {
                if(b==true)
                return false;
                a=true;
            }
            if(s.charAt(i)=='b')
            {
                b=true;
            }
        
        }
        return true;
    }
}
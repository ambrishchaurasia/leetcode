class Solution {
    public int passwordStrength(String password) {
        int ans=0;
        HashSet<Character> s=new HashSet<>();
        for(int i=0;i<password.length();i++)
        {
            s.add(password.charAt(i));
        }

            for(char ch:s)
        {
            
                if (ch>='a' && ch<='z')
                ans++;

                else if (ch>='A' && ch<='Z')
                ans+=2;

                else if (ch>='0' && ch<='9')
                ans+=3;
                else
                ans+=5;
            
        }
        return ans;
    }
}
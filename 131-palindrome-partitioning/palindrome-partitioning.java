
class Solution {

    public List<List<String>> partition(String s) {
            List<List<String>> ans=new ArrayList<>();
            List<String> curr=new ArrayList<>();
            rec(ans,curr,s,0);
            return ans;
    }

        void rec(List<List<String>> ans,List<String> curr,String s,int i)
        {
            if(i==s.length())
            {
                ans.add(new ArrayList<>(curr));
                return;
            }

           for(int j=i;j<s.length();j++)
           {
            if(isPal(i,j,s))
            {
                curr.add(s.substring(i,j+1));
                rec(ans,curr,s,j+1);
                curr.remove(curr.size()-1);

            }

           }
        }


    boolean isPal(int i,int j,String s)
    {
        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else
            return false;
        }
        return true;
    }
}
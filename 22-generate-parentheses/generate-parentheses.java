class Solution {
    List<String> ans=new ArrayList<>();
    int size=0;
    public List<String> generateParenthesis(int n) {
        String s="";
        size=n;
        rec(0,0,s);
        return ans;
    }
    void rec(int left,int right,String s)
    {
        if(left==size && right==size)
        {
            ans.add(s);
        }
        if(left<size)
        {
            rec(left+1,right,s+"(");
        }
        if(right<left)
        {
            rec(left,right+1,s+")");
        }
        
        
    }
}
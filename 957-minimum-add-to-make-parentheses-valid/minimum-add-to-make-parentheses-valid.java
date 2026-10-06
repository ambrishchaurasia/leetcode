class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack=new Stack();
        int ans=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            stack.push('(');
            else
            {
                if(stack.isEmpty())
                ans++;
                else
                stack.pop();
            }
        }
        if(stack.size()>0)
        ans+=stack.size();
        
        return ans;
    }
}
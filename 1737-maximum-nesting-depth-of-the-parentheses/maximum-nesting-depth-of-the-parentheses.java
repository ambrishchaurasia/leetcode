class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack=new Stack();
        int ans=-1;

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            stack.push('(');
            else if(s.charAt(i)==')')
            stack.pop();

            if(stack.size()>ans)
            ans=stack.size();
        }
        return ans;
    }
}
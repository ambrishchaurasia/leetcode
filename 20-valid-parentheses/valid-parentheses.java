class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(' || ch=='['||ch=='{')
            stack.push(ch);
            else
            {
                switch(ch)
                {
                case ')':
                if(!stack.isEmpty() && stack.peek()=='(')
                stack.pop();
                else return false;
                break;

                case ']':
                if(!stack.isEmpty() && stack.peek()=='[')
                stack.pop();
                else return false;
                break;

                case '}':
                if(!stack.isEmpty() && stack.peek()=='{')
                stack.pop();
                else return false;
                break;
                }
            }
        }
        return stack.isEmpty()?true:false;

    }
}
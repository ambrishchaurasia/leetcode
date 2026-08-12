class Solution {
    public boolean parseBoolExpr(String exp) {
        Stack<Character> s1=new Stack<>();
        Stack<Character> s2=new Stack<>();
        
        for(int i=0;i<exp.length();i++)
        {
        
            if(exp.charAt(i)==')')
            {
                char top='x';
                char operator=s2.pop();
                int c=0;
                boolean ans=false;
                while(s1.peek()!='(')
                {
                    top=s1.pop();
                    if(c==0)
                    {
                        if(top=='t')
                        {   ans=true;
                            if(operator=='!')
                            {
                            ans=false;
                            break;
                            }
                        }
                        else if(top=='f')
                        {
                         ans=false;
                         if(operator=='!')
                         ans=true;
                        }
                        c++;
                         continue;
                    }
                    
                    boolean cur=top=='t'?true:false;
                    switch(operator)
                    {
                    case '&':
                    ans=ans & cur;
                    break;
                    case '|':
                    ans=ans|cur;
                    break;
                    case '!':
                    ans=!cur;
                    break;
                    }
                    c++;
                }
                s1.pop();
                s1.push(ans?'t':'f');
            }

                if(exp.charAt(i)=='t'|| exp.charAt(i)=='f' ||exp.charAt(i)=='(')  
                s1.push(exp.charAt(i));
                else if(exp.charAt(i)=='!' || exp.charAt(i)=='&' || exp.charAt(i)=='|')
                s2.push(exp.charAt(i));
           
        }
        return s1.pop()=='t'?true:false;

    }
}
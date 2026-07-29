class Pair
{
    int val;
    int index;
    Pair(int val,int index)
    {
        this.val=val;
        this.index=index;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Pair> stack=new Stack();
        int ans[]=new int[temp.length];
        int n=temp.length;
        stack.push(new Pair(temp[n-1],n-1));
        ans[n-1]=0;

        for(int i=n-2;i>=0;i--)
        {
            while(stack.peek().val <=temp[i])
            {
                stack.pop();   

                if(stack.isEmpty())
                break; 
            }

            if(stack.isEmpty())
            {
                ans[i]=0;
                 stack.push(new Pair(temp[i],i));

                continue;
            }

            Pair a=stack.peek();
            int val=a.val;
            int index=a.index;
        
            ans[i]=index-i;
             stack.push(new Pair(temp[i],i));
            
        }
        return ans;
    }
}
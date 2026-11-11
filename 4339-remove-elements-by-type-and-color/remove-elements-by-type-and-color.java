class Solution {
    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        Stack<int[]> stack=new Stack<>();
        for(int i=0;i<types.length;i++)
        {
            if(!stack.isEmpty())
            {

                if(stack.peek()[0]==types[i] && stack.peek()[1]==colors[i])
                {
                    if(stack.peek()[2]+1==groupSize[types[i]])
                    {
                        stack.pop();
                    }
                    else
                    {
                        int size=stack.peek()[2];
                        stack.pop();
                        stack.push(new int[]{types[i],colors[i],size+1});
                    }
                }
                else
                {
                     if(groupSize[types[i]]!=1)
                    stack.push(new int[]{types[i],colors[i],1});

                }
            }
            else
            {
            if(groupSize[types[i]]!=1)
            stack.push(new int[]{types[i],colors[i],1});
            }
        }
        return stack.isEmpty();
    }
}
class Solution {
    public long shadowPairs(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        long ans=0;
        for(int i:nums)
        {
            while(!stack.isEmpty() && stack.peek()>i)
            {
                int x=stack.pop();
                hm.put(x,hm.get(x)-1);
            }
            ans+=stack.size()-hm.getOrDefault(i,0);
            stack.push(i);
            hm.put(i,hm.getOrDefault(i,0)+1);

        }
        return ans;
    }
}
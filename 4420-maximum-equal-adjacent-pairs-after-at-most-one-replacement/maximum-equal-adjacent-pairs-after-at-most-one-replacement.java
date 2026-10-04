class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int eq=0;
        HashMap<List<Integer>,Integer> hm=new HashMap<>();
        
        for(int i=0;i<nums.length-1;i++)
        {
            int n1=nums[i];
            int n2=nums[i+1];
            if(n1==n2)
            {
            eq++;
            continue;
            }
            else if(n1>n2)
            {
                int c=n1;
                n1=n2;
                n2=c;
            }
            List<Integer> cur=new ArrayList<>();
            cur.add(n1);
            cur.add(n2);

            if(!hm.containsKey(cur))
            hm.put(cur,0);
            hm.put(cur,hm.get(cur)+1);
        }
        int uneq=0;
        if(hm.size()>0)
        {
        List< Map.Entry< List<Integer>,Integer>> li=new ArrayList<>(hm.entrySet());
        Collections.sort(li,(x,y)->y.getValue()-x.getValue());
        uneq=li.get(0).getValue();
        }
        System.out.println(uneq);
        return eq+uneq;

    }
}
class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> cur=new ArrayList<>();
        rec(candidates,target,0,cur);
        return ans;
    }
    void rec(int[] candidates, int target, int index, ArrayList<Integer> cur)
    {
      
        if(target==0)
        {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if(target<0)
        return;

        if(index==candidates.length)
        return;

        //include
        cur.add(candidates[index]);
        rec(candidates,target-candidates[index],index,cur);
        cur.remove(cur.size()-1);

         //exclude
        rec(candidates,target,index+1,cur);

    }
}
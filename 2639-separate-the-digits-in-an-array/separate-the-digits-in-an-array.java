class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            String a=Integer.toString(nums[i]);
            for(int j=0;j<a.length();j++)
            {
                ans.add(a.charAt(j)-'0');
            }
        }
        int answer[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
        {
            answer[i]=ans.get(i);
        }
        return answer;
         }
}
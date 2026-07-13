class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String l=Integer.toString(low);
        int n=l.length();
        String s="";
        List<Integer> ans=new ArrayList<>();
        for(char i='1';i<='9';i++)
        {
            s=""+i;
           rec(low,high,s,i,ans);
        }
         Collections.sort(ans);
         return ans;
    }
    void rec(int low,int high,String s,char last ,List<Integer> ans)
    {
        
        int num = Integer.parseInt(s);
        if (num > high) {
    return;
}
        if (num >= low && num <= high) {
       ans.add(num);
         }

         if(last=='9')
        {
            return;
        }
        String news=s+(char)(last+1);
        rec(low,high,news,(char)(last+1),ans);
        
    }
}
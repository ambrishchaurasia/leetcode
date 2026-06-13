class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int sum=0;
        StringBuilder a=new StringBuilder();
        for(String w:words)
        {
            sum=0;
            for(int i=0;i<w.length();i++)
            {
                sum+=weights[w.charAt(i)-'a'];
            }
            sum=sum%26;
            char ch=(char)('z'-sum);
            a.append(ch);
        }
        return a.toString();

        
    }
}
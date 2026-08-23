class Solution {
    public int maxVowels(String s, int k) {
        int fre[]=new int[26];
        int []idx={0,4,8,14,20};
        int count=0;
        for(int i=0;i<k;i++)
        {
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u')
            {  
            int id=s.charAt(i)-'a';
            fre[id]++;
            count++;
            }
        }
        int max=count;

        int l=0;
        int r=k;

        while(r<s.length())
        {
             if(s.charAt(l)=='a' || s.charAt(l)=='e' || s.charAt(l)=='i' || s.charAt(l)=='o' || s.charAt(l)=='u')
             {
                count--;
             }
             if(s.charAt(r)=='a' || s.charAt(r)=='e' || s.charAt(r)=='i' || s.charAt(r)=='o' || s.charAt(r)=='u')
             {
                count++;
             }
             l++;
             r++;
             if(count>max)
             max=count;

        }
        return max;
        
    }
}
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int fre[]=new int[2];
        for(int i=0;i<moves.length();i++)
        {
            if(moves.charAt(i)=='L')
            fre[0]++;
           else if(moves.charAt(i)=='R')
           fre[1]++;
        }
        int x=fre[0]>fre[1]?0:1;
        for(int i=0;i<moves.length();i++)
        {
            if(moves.charAt(i)=='_')
            fre[x]++;


        }
        return Math.abs(fre[0]-fre[1]);
        
    }
}
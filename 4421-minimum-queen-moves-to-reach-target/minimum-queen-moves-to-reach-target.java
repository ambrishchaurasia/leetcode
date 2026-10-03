class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        if(source[0]==target[0] && source[1]==target[1])
        return 0;

        if(source[0]==target[0] || source[1]==target[1])
        return 1;
        
        int x=source[0];
        int y=source[1];
        int i=x;
        int j=y;
        while(i<=8&&j<=8 )
        {
            if(target[0]==i&& target[1]==j)
            return 1;
            i++;
            j++;
        }
         i=x;
         j=y;
        while(i>=1 && j<=8 )
        {
            if(target[0]==i&& target[1]==j)
            return 1;
            i--;
            j++;
        }
        i=x;
         j=y;
        while(i<=8&&j>=1 )
        {
            if(target[0]==i&& target[1]==j)
            return 1;
            i++;
            j--;
        }
        i=x;
         j=y;
        while(i>=1 && j>=1 )
        {
            if(target[0]==i && target[1]==j)
            return 1;
            i--;
            j--;
        }
        return 2;
    }
}
class Solution {
    public int minRange(int a, int b, int c) {
        int v0=max(a,b,c)-min(a,b,c);

        int a1=b+c;
        int v1=max(a1,b,c)-min(a1,b,c);

        v1=Math.min(v0,v1);

        int b1=a+c;
        int v2=max(a,b1,c)-min(a,b1,c);

        int c1=a+b;
        int v3=max(a,b,c1)-min(a,b,c1);

        return min(v1,v2,v3);
    
    }
    int max(int a,int b,int c)
    {
        return a>b?a>c?a:c:b>c?b:c;
    }
    int min(int a,int b,int c)
    {
        return a<b?a<c?a:c:b<c?b:c;
    }
}
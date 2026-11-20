class Solution {
    public long minimumMaxValue(int n, int index, int value) {
        int key=0;
        if(value==1 && n>1)
        return -1;
        int lim=(int)Math.ceil(Math.sqrt(value));
    
            //factors
            for(int i=3;i<=lim;i+=2)
            {
                if(value%i==0)
                {
                    key=i;
                    break;
                }
            }
            if(key==0)
            key=value;
        
        //checkback
        int id=index-1;
        int vc=value;
        int idx=id;
        if(id>=0 && key==value && value%2!=0)
        {
            return -1;
        }
        if(value%2!=0)
        {
            vc=vc-key;
            idx--;

        }
        int res=vc+(idx+1)*(-2);
        if(res<=0)
        return -1;


        //aage dekho
        id=index;
        int v=value;
        if(value%2!=0 && id+1<n)
        {
            id++;
            v=value+key;
        }
        return 1L*v+(n-id-1)*2;
    }
}
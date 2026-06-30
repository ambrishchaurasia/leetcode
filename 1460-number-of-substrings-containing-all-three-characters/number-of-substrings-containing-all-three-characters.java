class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int a[]=new int[n];
        int b[]=new int[n];
        int c[]=new int[n];

        int i=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='a')
            {
            if(i==0)
            a[i]=1;
            else
            {
            a[i]=a[i-1]+1;
            b[i]=b[i-1];
            c[i]=c[i-1];
            }
            }

           else if(ch=='b')
            {
            if(i==0)
            b[i]=1;
            else
            {
            b[i]=b[i-1]+1;
            a[i]=a[i-1];
            c[i]=c[i-1];
            }
            }

            else
            {
            if(i==0)
            c[i]=1;
            else
            {
            c[i]=c[i-1]+1;
            b[i]=b[i-1];
            a[i]=a[i-1];
            }
            }
            i++;
        }
        int ans=0;
        int j=0;
        for(i=0;i<n;i++)
        {
            while(j<n)
                {
                if(i==0)
                {
                    if(a[j]>0 && b[j]>0 && c[j]>0)
                    {
                    ans+=(n-j);
                    break;
                    }
                }
                else
                {
                    int af=a[j]-a[i-1];
                    int bf=b[j]-b[i-1];
                    int cf=c[j]-c[i-1];
                    if(af>0 && bf>0 && cf>0)
                    {
                    ans+=(n-j);
                    break;
                    }
                }
                j++;
            }
        }
        return ans;

    }
}
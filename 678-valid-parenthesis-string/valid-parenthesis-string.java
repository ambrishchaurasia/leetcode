class Solution {
    public boolean checkValidString(String s) {
        int mcount =0;
       int mxcount =0;
       

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
            mcount++;
            mxcount++;
            }

            else if(s.charAt(i)==')')
            {
             mcount--;
            mxcount--;
            }

            else
            {
                mcount--;
                mxcount++;
            }
            if(mcount<0)
            mcount=0;

            if(mxcount<0)
            return false;
      }
              return mcount==0;
    }
}
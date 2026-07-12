class Solution {
    public int[] arrayRankTransform(int[] arr) {

        if(arr.length==0)
        return new int[]{};

        int arr1[]=new int[arr.length];
        
        for(int i=0;i<arr.length;i++)
        {
            arr1[i]=arr[i];
        }
        Arrays.sort(arr1);
        int r=1;
        int i=1;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(arr1[0],1);
        while(i<arr1.length)
        {
            while(i<arr1.length && arr1[i-1]==arr1[i])
            {
            i++;
            }
            if(i==arr1.length)
            break;
            r++;
            hm.put(arr1[i],r);
            i++;
        }
        for(int j=0;j<arr.length;j++)
        {
            arr1[j]=hm.get(arr[j]);
        }
        return arr1;
    }
}
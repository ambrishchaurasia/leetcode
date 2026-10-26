class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        HashSet<String> set=new HashSet();
        for(String i:wordList)
        {
            set.add(i);
        }
        set.remove(beginWord);
        int ans=1;
        while(!queue.isEmpty())
        {
            int n=queue.size();

            for(int i=0;i<n;i++)
            {
                String word=queue.poll();

                for(int j=0;j<beginWord.length();j++)
                {
                    for(int k=0;k<26;k++)
                    {
                        int idx='a'+k;
                        char replace=(char)idx;
                        String cur=word.substring(0,j)+replace+word.substring(j+1,beginWord.length());
                        if(set.contains(cur))
                        {

                            if(cur.equals(endWord))
                            return ans+1;
                            set.remove(cur);
                            queue.offer(cur);
                        }
                    }
                }
            }
            ++ans;
        }
        return 0;
    }
}
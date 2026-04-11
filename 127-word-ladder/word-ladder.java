class Pair{
    String word;
    int rank;
    Pair(String word,int rank)
    {
        this.word=word;
        this.rank=rank;
    }
}
class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++)
        {
            set.add(wordList.get(i));
        }
        Pair a=new Pair(beginWord,1);
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(a);
        set.remove(beginWord);

        return bfs(queue,set,endWord);

     }

         int bfs(Queue<Pair> queue,Set<String> set,String endWord)
        {
               while(!queue.isEmpty())
               {
                Pair x=queue.poll();
                String w=x.word;
                int y=x.rank;
                
                if(w.equals(endWord))
                return y;

                for(int i=0;i<w.length();i++)
                {
                  for(int j=0;j<26;j++)
                  {
                    int index='a'+j;
                    char c=(char)index;
                    String z=w.substring(0,i)+c+w.substring(i+1,w.length());
                    if(set.contains(z))
                    {
                        queue.offer(new Pair(z,y+1));
                        set.remove(z);
                    }
                  }  
                }
                
               }
               return 0;
        }
}
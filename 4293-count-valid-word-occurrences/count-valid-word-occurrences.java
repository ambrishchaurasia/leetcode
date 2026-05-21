class Solution {
    boolean isChar(char a)
    {
        if(a>='a' && a<='z')
        return true;
        else
        return false;
    }
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<chunks.length;i++)
        {
            ans.append(chunks[i]);
        }
        StringBuilder answer=new StringBuilder(); 

            for(int j=0;j<ans.length();j++)
            {
               if(isChar(ans.charAt(j)))
                {
                    answer.append(ans.charAt(j));
                }
                else if(ans.charAt(j)=='-')
                {
                    if(j==0 || j==ans.length()-1)
                    {
                        answer.append(" ");
                    }
                    else if(isChar(ans.charAt(j-1)) && isChar(ans.charAt(j+1)))
                        {
                          answer.append(ans.charAt(j));    
                        }
                        else
                        answer.append(' ');    

                }
                else
                {
                    answer.append(' ');    
                }

            }
            String fi=answer.toString();
            String fa[]=fi.trim().split("\\s+");
            int[] finalans=new int[queries.length];

            HashMap<String,Integer> hashmap=new HashMap<>();
           for(String w:fa)
           {
            hashmap.put(w,hashmap.getOrDefault(w,0)+1);
           }
           int i=0;
           for(String w:queries)
           {
           finalans[i++]= hashmap.getOrDefault(w,0);
           }

    return finalans;
            }
        }
    

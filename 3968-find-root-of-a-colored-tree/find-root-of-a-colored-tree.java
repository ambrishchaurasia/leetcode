
import java.util.*;

class Solution {
    public int findColoredRoot(int[][] edges, String colors) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < colors.length(); i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];

            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }

        Object[] lumelosile = new Object[]{edges, colors};



        for (int i = 0; i < colors.length(); i++) {

            // Root cannot have more than two children
            if (adj.get(i).size() > 2)
                continue;

            Queue<int[]> queue = new LinkedList<>();
            boolean[] vis = new boolean[colors.length()];

            queue.offer(new int[]{i, -1});
            vis[i] = true;
            char clr=colors.charAt(i);
            String seq="";
            if(clr=='R')
            {
                seq="RBW";
            }
            else if(clr=='B')
            {
                seq="BWR";
            }
            else
            seq="WRB";

            boolean con = true;
            int level = 0;


            while (!queue.isEmpty() && con) {

                int n = queue.size();

                // Expected color at this depth
                char expected = seq.charAt((level)%3);
               

                for (int k = 0; k < n; k++) {

                    int[] a = queue.poll();
                    int na = a[0];
                    int pa = a[1];

                    // Validate color at current depth
                    if (colors.charAt(na) != expected) {
                        con = false;
                        break;
                    }

                    int children = 0;

                    for (int nei : adj.get(na)) {
                        if (nei == pa)
                            continue;

                        children++;

                        // Every node can have at most two children
                        if (children > 2) {
                            con = false;
                            break;
                        }

                        if (!vis[nei]) {
                            vis[nei] = true;
                            queue.offer(new int[]{nei, na});
                        }
                    }

                    if (!con)
                        break;
                }

                ++level;
            }

            if (con) {
                return i;
            }
        }

        return -1;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> hm =new HashMap<>();
        TreeNode node;

        for(int []i:descriptions)
        {
            if(hm.containsKey(i[0]))
            node=hm.get(i[0]);
            else
            {
                node=new TreeNode(i[0]);
                hm.put(i[0],node);
            }
                 TreeNode child;
                if(hm.containsKey(i[1]))
                 child=hm.get(i[1]);
                 else
                 {
                 child=new TreeNode(i[1]);
                 hm.put(i[1],child);
                 }
            if(i[2]==1)
            node.left=child;
            else
            node.right=child;

        }
        HashSet<Integer> unique=new HashSet<>();
        for(int []i:descriptions)
        {
            unique.add(i[1]);
        }
        TreeNode ans=new TreeNode();
        for(Map.Entry<Integer,TreeNode> it:hm.entrySet())
        {
            if(!unique.contains(it.getKey()))
            ans=hm.get(it.getKey());

        }
return ans;
    }
}
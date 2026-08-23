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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
        return ans;
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
            List<Integer> arr=new ArrayList<>();
            int n=queue.size();
            for(int i=0;i<n;i++)
            {
            TreeNode a=queue.poll();
            arr.add(a.val);

             if(a.left!=null)
            queue.offer(a.left);
            if(a.right!=null)
            queue.offer(a.right);
            }
            ans.add(arr);
           
        }
        return ans;
        
    }
}
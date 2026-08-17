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
    boolean ans=true;
    public boolean isBalanced(TreeNode root) {
rec(root);
return ans;

    }

    int rec(TreeNode root)
    {
        if(root==null)
        return 0;

        int lh=1+ rec(root.left);
        int rh=1+ rec(root.right);

        if(Math.abs(lh-rh)>1)
        ans=false;

        return Math.max(lh,rh);
    }
}
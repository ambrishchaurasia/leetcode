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
    int cnt=0;
    public int averageOfSubtree(TreeNode root) {
        avg(root);
        return cnt;

    }
    int[] avg(TreeNode root)
    {
        if(root==null)
        return new int[]{0,0};

        int left[]=avg(root.left);
        int right[]=avg(root.right);
        int num=left[0]+right[0]+1;
        int sum=left[1]+right[1]+root.val;
        int avg=(sum/num);
        if(avg==root.val)
        cnt++;
        return new int[]{num,sum};
    }
}
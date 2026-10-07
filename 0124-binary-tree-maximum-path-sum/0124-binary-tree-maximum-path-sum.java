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
    int optimalVal=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        optimalPath(root);
        return optimalVal;
    }
    public int optimalPath(TreeNode root){
          if(root==null) return 0;
        int leftPath=Math.max(0,optimalPath(root.left));

        int rightPath=Math.max(0,optimalPath(root.right));
        
          int maxoptimal=  Math.max(leftPath,rightPath);
        optimalVal = Math.max(leftPath+rightPath+root.val,optimalVal);
        return root.val + maxoptimal;
    }
}
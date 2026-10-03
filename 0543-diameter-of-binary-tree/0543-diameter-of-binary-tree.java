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

//i am thinking about iterating left and right node of particular node then total lemgth will be l+r were l=1+diameterOfBinaryTree(root.right); and same r=    if r is not available then max hieght is legth of node to root of left most side 
class Solution {
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        findLength(root);
        return diameter;
    }
    public int findLength(TreeNode root){
          if(root==null) return 0;
        int l=findLength(root.left);

        int r=findLength(root.right);
        diameter = Math.max(l+r,diameter);
       int maxLen=  Math.max(l,r);

        return 1+maxLen;
    }
}
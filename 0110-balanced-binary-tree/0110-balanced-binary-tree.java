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


 // see balance tree mean on left and right of root node should be equal node or diff not more than 1 
 // initially i am thinking that this is for onlt root node that why mine approach is pass left and right node of root node in height, int l=height(root.left) and same for r 
 //then check in final l-r diff is not more than 1 
 // but balance mean child root should balance then we iterate to leaf node, if we found its unbalance return -1 else return max height from left or right of that node 
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(height(root)==-1) return false;
        return true;
    }
    private int height(TreeNode root){
        if(root ==null) return 0;
        int l=height(root.left);
        if(l==-1) return -1;
        int r=height(root.right);
        if(r==-1) return -1;
        if(Math.abs(l-r)>1) return -1;

        return 1+Math.max(l,r);
    }

}

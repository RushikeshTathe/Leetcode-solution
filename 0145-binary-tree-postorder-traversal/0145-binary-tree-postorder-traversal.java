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
    public List<Integer> postorderTraversal(TreeNode root) {
     ArrayList<Integer> ans=new ArrayList<>();
     Stack <TreeNode> st1=new Stack<>();
      Stack<TreeNode> st2 = new Stack<>();
       if (root == null) return ans;
     
     st1.push(root);
     while(!st1.isEmpty()){
       TreeNode current=st1.pop();
        st2.push(current);
        if(current.left!=null){
            st1.push(current.left);
        }
        if(current.right!=null){
             st1.push(current.right);
        }  
     }
     while(!st2.isEmpty()){
        ans.add(st2.pop().val);
     }
      return ans;
    }
   
}
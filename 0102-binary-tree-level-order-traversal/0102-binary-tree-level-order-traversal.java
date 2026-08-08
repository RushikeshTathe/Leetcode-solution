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
        if (root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        filledValue(root, queue, ans);
        return ans;
        
    }
    public void filledValue(TreeNode root,Queue<TreeNode>queue,List<List<Integer>> ans){
       
        while(!queue.isEmpty()){
            int size=queue.size();
             List<Integer> levelValue=new ArrayList<>();
             for(int i=0;i<size;i++){

           TreeNode currentNode=queue.poll();
            levelValue.add(currentNode.val);
            if(currentNode.left!=null){
            queue.offer(currentNode.left);}
            if(currentNode.right!=null){
                queue.offer(currentNode.right);
            }
             }
         ans.add(levelValue);
        }
       return;
    }
}
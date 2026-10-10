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
     List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return res;
        }
         Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
             List<Integer> level= new ArrayList<>();
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                level.add(node.val);
               if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(level);
        }
     for (int i = 1; i < res.size(); i += 2) {
            Collections.reverse(res.get(i));
        }
        return res;
    }
}
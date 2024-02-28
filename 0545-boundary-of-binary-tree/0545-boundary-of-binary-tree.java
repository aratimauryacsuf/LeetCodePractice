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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        dfs(root.left, true, false ,res);
         dfs(root.right, false, true,res);
        return res; 
    }

    public void dfs(TreeNode node, boolean leftMost, boolean rightMost, List<Integer> res){
        if(node == null) return ;
        if(node.left == null && node.right == null ){
            res.add(node.val);
            return;
        } 
       if(leftMost) res.add(node.val);
       dfs(node.left, leftMost, rightMost && node.right == null, res);
       dfs(node.right, leftMost && node.left == null, rightMost,res);
       if(!leftMost && rightMost){
           res.add(node.val);
       }
       
      
    }
}
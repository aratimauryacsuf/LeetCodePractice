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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root== null) return false;
      /* Using DFS 
        if(root.left==null && root.right==null && root.val == targetSum) return true;
        
        return hasPathSum(root.left, targetSum - root.val)|| hasPathSum(root.right,targetSum - root.val);
        */
        
        //Using BFS
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node =stack.pop();
            
            if(node.left == null && node.right == null && node.val == targetSum) return true;
           //  targetSum = targetSum - node.val;
            
            if(node.left != null){
              //  targetSum = targetSum - node.val;
                node.left.val = node.left.val + node.val;
                stack.push(node.left);
               
            }
            
            
            if(node.right != null) { 
                node.right.val = node.right.val + node.val;
              // targetSum = targetSum - node.val;
                stack.push(node.right);
               
            }
            
        }
        
        return false;
        
    }
}
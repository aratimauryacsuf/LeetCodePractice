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
    int maxDepth;
    int result;
    public int findBottomLeftValue(TreeNode root) {
        result = 0;
        maxDepth = -1;
        dfs(root, 0);
        
        return result;
        
    }
    
    public void dfs(TreeNode node, int depth){
        if(node == null) return;
        if(depth > maxDepth){
            maxDepth = depth;
            result = node.val;
        }
        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }
}
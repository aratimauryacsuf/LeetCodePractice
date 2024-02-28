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
    public int longestConsecutive(TreeNode root) {
      return  dfs(root, null, 0); 
    }
    private int dfs(TreeNode child, TreeNode parent, int length){
        if(child == null) return length;
        length = (parent != null && child.val == parent.val +1) ? length +1 : 1;
       return Math.max(length, Math.max(dfs(child.left, child,length),dfs(child.right, child, length)));
    }
}
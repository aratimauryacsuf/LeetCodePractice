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
//  Second solution without using global variable
class Solution {
    //  int count =0;
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        dfs(root, count);
        return count[0];
        
    }
    public boolean dfs(TreeNode node, int[] count ){
        if(node == null){
            return true;
        }
        boolean left = dfs(node.left, count);
        boolean right = dfs(node.right, count);
        if(left && right){
            if(node.left != null && node.left.val != node.val) return false;
            if(node.right != null && node.right.val != node.val) return false;
            count[0]++;
            return true;
        }
        return false;
    }
}
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
    int maxVal;
    public int maxPathSum(TreeNode root) {
        maxVal = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return maxVal;
    }
    
    public int maxPathSumHelper(TreeNode node){
        if(node == null) return 0;
        int left = Math.max(0, maxPathSumHelper(node.left));
        int right = Math.max(0, maxPathSumHelper(node.right));
        maxVal = Math.max(maxVal, left+right+node.val);
        return Math.max(left,right)+node.val;
    }
}
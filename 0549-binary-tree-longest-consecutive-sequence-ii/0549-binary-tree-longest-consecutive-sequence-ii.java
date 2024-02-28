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
    int maxValue =0;
    public int longestConsecutive(TreeNode root) {
        longestDFS(root);
        return maxValue; 
    }
    public int[] longestDFS(TreeNode root){
        if(root == null){
            return new int[] {0,0};
        }
        int inc =1, dec =1;
        if(root.left != null){
            int[] left = longestDFS(root.left);
            if(root.left.val == root.val +1){
                dec = left[1] +1;
            }else if(root.left.val == root.val -1 ){
                inc = left[0] +1;
            }
        }
        if(root.right != null){
            int[] right = longestDFS(root.right);
            if(root.right.val == root.val +1){
                dec = Math.max(dec, right[1]+1);
            }else if (root.right.val == root.val -1){
                inc = Math.max(inc, right[0]+1);
            }
        }
        maxValue = Math.max(maxValue, dec + inc -1);
        return new int[] {inc, dec};
    }
}
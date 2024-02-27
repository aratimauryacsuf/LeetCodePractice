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
    int max =0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        
        return max;
    }
    
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        //System.out.println("root: "+root.val);
        int left =maxDepth(root.left);
       // System.out.println("root.right:");
        int right = maxDepth(root.right);
        //System.out.println("root: " + root.val+" left: "+ left + " right: "+ right);
        max =Math.max(max, left+right);
        System.out.println("max:" +max);
        
        return Math.max(left,right)+1;
    }
}
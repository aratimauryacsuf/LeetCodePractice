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
    int prev = Integer.MAX_VALUE;
    int ans = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {

        inOrder(root);

      return ans ;
    }

public void inOrder(TreeNode root){
    if(root == null) return;

    inOrder(root.left);
    ans= Math.min(ans,Math.abs( root.val - prev));
    prev = root.val;

    inOrder(root.right);
}
}
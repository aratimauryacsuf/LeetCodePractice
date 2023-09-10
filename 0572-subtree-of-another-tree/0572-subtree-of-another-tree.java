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
    public boolean isSubtree(TreeNode r, TreeNode s) {
       if(r == null) return false;
    
        if(isSame(r,s)) return true;
        
        return isSubtree(r.left, s) || isSubtree(r.right,s);
        
        
    }
     public boolean isSame(TreeNode t, TreeNode s){
         if(t == null && s == null) return true;
         if(t == null || s == null) return false;
         
         if(t.val != s.val) return false;
         
         return isSame(t.left,s.left) && isSame(t.right,s.right);
         
     }
}
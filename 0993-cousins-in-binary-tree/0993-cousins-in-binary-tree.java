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
    public boolean isCousins(TreeNode root, int x, int y) {
        //if x or y at root then they can't be at same depth
        
        if(root.val == x || root.val == y) return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        boolean xfound = false;
        boolean yfound = false;
        
        int parentX = 0;
        int parentY = 0;
        
        q.offer(root);
        
        while(!q.isEmpty() && !xfound && !yfound){
            int size = q.size();
            
            while(size > 0 ){
                size--;
                
                TreeNode node = q.poll();
                
                if(node.left != null){
                    q.offer(node.left);
                    
                    if(node.left.val == x){
                        xfound = true;
                        parentX = node.val;
                    }
                    if(node.left.val == y){
                        yfound =true;
                        parentY = node.val;
                    }
                    
                }
                if(node.right != null){
                    q.offer(node.right);
                    
                    if(node.right.val == x){
                        xfound = true;
                        parentX = node.val;
                    }
                    if(node.right.val == y){
                        yfound =true;
                        parentY = node.val;
                    }
                    
                }
            }
        }
        
        return xfound && yfound && parentX != parentY;
        
    }
}
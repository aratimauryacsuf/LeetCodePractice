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
    public int sumEvenGrandparent(TreeNode root) {
        
        if(root == null) return 0;
        
        int sum =0;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<= size -1; i++){
                 TreeNode node = q.poll();
            if(node.left != null ){
                q.offer(node.left);
                if(node.left.left != null && node.val % 2 ==0){
                    sum = sum + node.left.left.val;
                }
                if(node.left.right != null && node.val % 2 ==0){
                    sum = sum + node.left.right.val;
                }
            }
            if(node.right != null ){
                q.offer(node.right);
                if(node.right.left !=null && node.val % 2 ==0){
                    sum = sum + node.right.left.val;
                }
                if(node.right.right !=null && node.val % 2 ==0){
                    sum = sum + node.right.right.val;
                }
            }       
            }
               
            
        }
        
        return sum;
    }
}
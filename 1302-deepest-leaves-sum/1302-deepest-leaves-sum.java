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
    int maxLevel = 0;
    int sum =0;
    public int deepestLeavesSum(TreeNode root) {
   
      
    //Bfs Implementation
        /*
        if(root == null) return 0;
        
        int sum =0;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            sum =0;
            for(int i=0 ; i<= size-1;i++){
                TreeNode node = q.poll();
                sum = sum + node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right !=null) q.offer(node.right);
            }
            
        }
        
        return sum;
        */
        
        //DFS Implementation
        
        if(root == null) return 0;
        
        deepestLeavesSum(root, 0);
        
        return sum;
        
    }
    
    public void  deepestLeavesSum(TreeNode root, int level){
        if(root == null) return;
        
        if(level > maxLevel){
            sum =0;
            maxLevel = level;
        }
        if(level == maxLevel){
            sum = sum + root.val;
        }
        
        deepestLeavesSum(root.left , level+1);
        deepestLeavesSum(root.right, level +1);
    }

}
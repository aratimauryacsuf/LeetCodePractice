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
   private List<Integer> prev = new ArrayList<>();
    public boolean isEvenOddTree(TreeNode root) {
       // isEvenOdd =false;
      //  isEvenOddHelper(root, 0);
        
        return  isEvenOddHelper(root, 0);
    }
    
    public boolean isEvenOddHelper(TreeNode node, int level){
        
       
         if(node == null) return true;
         //System.out.println("root:" + node.val +" level: "+level);
        
        if(node.val %2 == level%2) return false;
        
        while(prev.size() <= level){
            prev.add(0);
        }
        
        if((prev.get(level) != 0 )
           &&((level %2 ==0 && node.val <= prev.get(level))
                                   || (level % 2 == 1 && node.val >= prev.get(level) ))){
             //System.out.println("Inside if loop    root:" + node.val +" level: "+level + " Prev:"+ prev.get(level) );
            return false;
        }
        
        prev.set(level, node.val);
        
        return isEvenOddHelper(node.left , level+1) && isEvenOddHelper(node.right , level+1);
    }
}
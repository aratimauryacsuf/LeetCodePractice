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
    // double maxSum = Integer.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        double[] maxAvg = new double[1];
      
         dfs(root, maxAvg);
         return maxAvg[0]; 
    }
    public int dfs(TreeNode node, double[] maxAvg){
        if( node == null){
            return 0;
        }
        int left = dfs(node.left,maxAvg);
        int right = dfs(node.right,maxAvg);
        int sum = left + right + node.val;
        double average = (double)sum/(double)(countNodes(node.left) + countNodes(node.right)+1);
        maxAvg[0] = Math.max(maxAvg[0], average);

        return sum;
    }
    public int countNodes(TreeNode root){
        if(root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) +1;
    }
}
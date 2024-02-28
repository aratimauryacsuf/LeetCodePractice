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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        HashSet<Integer> root1List = new HashSet<>();
        HashSet<Integer> root2List = new HashSet<>();
        dfs(root1 , root1List);
        dfs(root2, root2List);
        for(int a : root1List){
           if(root2List.contains(target - a)){
               return true;
           }
            }
        
       return false; 
    }
    public void dfs(TreeNode root, HashSet<Integer> list){
        if(root == null) return;
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }

}
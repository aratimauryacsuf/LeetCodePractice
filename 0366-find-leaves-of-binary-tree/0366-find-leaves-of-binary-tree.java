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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,res);
        return res;  
    }
    public int dfs(TreeNode root, List<List<Integer>> res ){
        if(root == null) return -1;
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        int level = Math.max(left, right) +1;
        if(res.size() <= level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        return level;
        
    }
}
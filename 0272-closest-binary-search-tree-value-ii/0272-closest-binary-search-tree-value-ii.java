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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> Maxheap = new PriorityQueue<>((a,b)-> Math.abs(a- target) > Math.abs(b - target) ? -1:1);
        dfs(root, Maxheap, k);
        return new ArrayList<>(Maxheap); 
    }
    public void dfs(TreeNode node,  Queue<Integer> Maxheap, int k ){
        if(node == null) return ;
        Maxheap.add(node.val);
        if(Maxheap.size() > k){
            Maxheap.remove();
        }
        dfs(node.left, Maxheap,k);
        dfs(node.right, Maxheap,k);
    }
}
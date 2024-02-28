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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)return result;
        Map<Integer, ArrayList> colTable = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        int col =0;
        queue.offer(new Pair(root,col));
        int minCol=0, maxCol=0;
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            col = p.getValue();
            if(root != null){
                if(!colTable.containsKey(col)){
                    colTable.put(col, new ArrayList<Integer>());
                }
                colTable.get(col).add(root.val);
                minCol = Math.min(minCol, col);
                maxCol = Math.max(maxCol, col);
                queue.offer(new Pair(root.left, col-1));
                queue.offer(new Pair(root.right, col+1));
            }
        }

        for(int i = minCol; i < maxCol +1; ++i){
            result.add(colTable.get(i));
        }
        return result; 
    }
}
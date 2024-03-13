/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public int i =0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String>  list = new ArrayList<>();
        serializeDFS(root, list);
       // System.out.println("String:   "+String.join(",", list));
        return String.join(",", list);
        
    }
    
    public void serializeDFS(TreeNode root, List<String> list){
        if(root == null){
            list.add("N");
            return;
        }
        //preorder traversal
        
        list.add(String.valueOf(root.val));
        serializeDFS(root.left, list);
        serializeDFS(root.right, list);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        return deserializeDFS(tokens);
        
        
    }
    
     private TreeNode deserializeDFS(String[] tokens) {
        String token = tokens[this.i];
        if (token.equals("N")) {
            this.i++;
       //     System.out.println("i:::: "+ this.i);
            return null;
        }
      //   System.out.println("node::" + Integer.parseInt(token));
        TreeNode node = new TreeNode(Integer.parseInt(token));
        this.i++;
        node.left = deserializeDFS(tokens);
        node.right = deserializeDFS(tokens);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
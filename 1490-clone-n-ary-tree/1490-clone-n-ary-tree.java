/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node cloneTree(Node root) {
        if(root == null) return root;
        Node newRoot = new Node(root.val);
        Queue<Node[]> q = new ArrayDeque<>();
        q.offer(new Node[]{root, newRoot});
        while(!q.isEmpty()){
            Node[] nodePair = q.poll();
            Node oldNode = nodePair[0];
            Node newNode = nodePair[1];
            for(Node child : oldNode.children){
                Node newChild =new Node(child.val);
                newNode.children.add(newChild);
                q.offer(new Node[]{child, newChild});
            }
        }
        return newRoot;
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }
        Node cur = head;
        while(cur.next != head){
            if(cur.val <= cur.next.val){
                if(insertVal >= cur.val && insertVal <= cur.next.val){
                    break;
                }

            }else{
                if(insertVal >= cur.val || insertVal <= cur.next.val){
                    break;
                }

            }
            cur = cur.next;
        }
        Node next = cur.next;
        cur.next = new Node(insertVal, next);
        return head;
        
    }
}
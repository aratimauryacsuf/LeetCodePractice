/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode current = head;
        ListNode forwardNode = head;
        for (int i = 0; i < n; i++){
            forwardNode = forwardNode.next;
        }
        if(forwardNode == null)
           return head.next;
        while(forwardNode.next != null){
            current = current.next;
            forwardNode = forwardNode.next;
        }
        
        current.next = current.next.next;
    
        return head;
    }
}
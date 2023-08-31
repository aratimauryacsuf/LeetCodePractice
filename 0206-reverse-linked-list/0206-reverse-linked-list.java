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
    public ListNode reverseList(ListNode head) {
//         //ListNode current = head; 
//        // ListNode result = null;
//         if(head.next != null){
            
//             ListNode current = reverseList(head.next);
//              System.out.println("head: "+head.val + " current:" + current.val);
//             current.next = head;
//             head.next = null;
        

//         }
//         //    return current;
        
        
//         return head;
        
// Iterative approach        
    /*    ListNode prev = null;
        ListNode current = head; 
        
        while(current != null){
            ListNode next =current.next; 
            current.next = prev;
            prev = current; 
            current = next;
        }
        
        return prev;
     */
    // Recursive 
        
        if(head == null || head.next ==null){
           // System.out.println("head:"+ head.val);
            return head;
        }
        ListNode nextnode =head.next; 
      
        ListNode newhead = reverseList(nextnode);
     
        nextnode.next  = head;
       
        head.next =null;
        
        return newhead;
    }
}
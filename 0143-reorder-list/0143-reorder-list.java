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
    public void reorderList(ListNode head) {
        ListNode n1 = head;
        ListNode n2 = head;
        
        while(n2.next != null){
            n1 =n1.next;
            
            if(n2.next !=null){
                n2= n2.next;
            }
            if(n2.next !=null){
                n2= n2.next;
            }        
        }
        
        n2 = n1.next;
        n1.next = null;
        
        ListNode rev = reverse(n2);
        
       // ListNode result = new ListNode();
        
        ListNode temp1, temp2;
        ListNode current = head;
        while(current!= null && rev !=null){
            temp1 = current.next;
            temp2 = rev.next;
            
            current.next = rev;
            rev.next = temp1;
            
            current = temp1;
            rev = temp2;
        }
        
        
        
     if( current!= null){
         current  = current.next;
     }else{
         current = rev.next;
     }
       
        
    }
    
    public ListNode reverse(ListNode node){
        ListNode current = node;
        ListNode prev = null;
        while(current != null){
           ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    
    
}
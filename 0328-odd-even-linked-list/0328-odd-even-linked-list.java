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
    public ListNode oddEvenList(ListNode head) {
        if(head != null){
        ListNode oddList = head;
        ListNode evenList = head.next;
        ListNode evenHead = evenList;
        
        while(evenList != null && evenList.next != null){
           
              oddList.next = oddList.next.next;
            evenList.next = evenList.next.next;
          
            evenList = evenList.next;
            oddList = oddList.next;
        }
        
        oddList.next = evenHead;
        }
        return head;
    }
}
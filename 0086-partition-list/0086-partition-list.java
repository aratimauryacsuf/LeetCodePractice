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
    public ListNode partition(ListNode head, int x) {
        if(head == null ) return null;
        
        ListNode left=null, right=null, lefttail=null, righttail =null ;

        while(head != null){
            if(head.val < x){
                if(left == null){
                    left = head;
                    lefttail = left;
                }
                else {
                    lefttail.next = head;
                    lefttail = lefttail.next;
                }
            }
            else{
                if(right == null){
                    right = head;
                    righttail = head;
                }
                else {
                    righttail.next = head;
                    righttail = righttail.next;
                }
            }
            head = head.next;
        }
        if(lefttail == null && righttail != null){
            return right;
        }else if(righttail == null && lefttail !=null){
            return left;
        }else{
            lefttail.next = right;
            righttail.next = null;
            return left;
        }
        
        
    
       

          }

}
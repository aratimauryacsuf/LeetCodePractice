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
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
       ListNode head =null;
    ListNode result = null;
        
        if(list1 == null){
            result = list2;
            }
        if(list2 == null){
            result = list1;
        }
        
        int carry =0;
        while(list1 != null || list2 != null || carry >0){
            int sum =0;
            
            if(list1 != null && list2 != null){
                sum = list1.val + list2.val + carry;
                list1 = list1.next;
                list2 = list2.next;
            }else if(list1 != null && list2 == null){
                sum = list1.val +carry;
                list1 = list1.next;
            }else if(list2 != null && list1 == null){
                sum = list2.val + carry;
                list2 = list2.next;
            }else{
                sum = carry;
            }
            
            int newVal = sum %10;
            carry = sum / 10;
            
            ListNode node = new ListNode(newVal);
            if(head == null){
                head = node;
                result = node;
            }else{
                result.next = node;
                result = result.next;
            }
        }
         return head;
    }
}
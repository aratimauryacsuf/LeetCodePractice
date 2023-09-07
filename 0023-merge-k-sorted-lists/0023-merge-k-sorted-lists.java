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
    public ListNode mergeKLists(ListNode[] lists) {
        int len  = lists.length ;
        if(len == 0) return null;
        if(len ==1) return lists[0];
        
        int mid = len / 2;
        
        ListNode[] left = new ListNode[mid];
        for(int i =0; i< mid;i++){
            left[i] = lists[i];
        }
        ListNode[] right = new ListNode[len - mid];
        for(int i =0; i< len -mid;i++){
            right[i] = lists[mid +i];
        }
        
        ListNode list1 = mergeKLists(left);
        ListNode list2 =mergeKLists(right);
        
        return mergeLists(list1,list2);
    }
    
     public ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode temp =new ListNode();
        ListNode curr = temp;
        while(list1 !=null && list2 != null){
         if(list1.val< list2.val){
             curr.next =list1;
             list1 =list1.next;
         }
         else{
             curr.next =list2;
             list2 =list2.next;
         }
         curr=curr.next;
        }
        if(list1 !=null){
            curr.next =list1;
        }else{
            curr.next =list2;
        }
        
        return temp.next;
    }
}
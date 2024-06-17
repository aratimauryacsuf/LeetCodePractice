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
   // approach 1
  /*  public int pairSum(ListNode head) {
        
        ArrayList<Integer> al = new ArrayList<>();
        
        while(head != null){
            al.add(head.val);
            head = head.next;
        }
        
        int i =0; 
        int j = al.size() -1;
        int sum = 0;
        
        while(i < j){
            sum = Math.max(sum , al.get(i)+al.get(j));
            i++;
            j--;
        }
        
        return sum;   
        
    }
    */
    
    // approach 2
    
    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return head.val;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow);
        fast = head;
        int sum = Integer.MIN_VALUE;
        while (slow != null) {
            sum = Math.max(slow.val + fast.val, sum);
            slow = slow.next;
            fast = fast.next;
        }
        return sum;
    }
    
    public ListNode reverse(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode current = node;
        ListNode previous = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
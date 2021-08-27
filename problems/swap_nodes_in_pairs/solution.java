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
    public ListNode swapPairs(ListNode head) {
        
        if(head == null){
            return null;
        }
        
        ListNode result = new ListNode();
        ListNode root = result;
        while(head != null){
            ListNode next = head.next;
            if(next == null){
                root.val = head.val;
                break;
            }
            
            root.val = next.val;
            root.next = new ListNode(head.val);
            root = root.next;
            
            head = next.next;
            
            if(head != null){
                root.next = new ListNode();
                root = root.next;
            }
        }
        return result;
    }
}
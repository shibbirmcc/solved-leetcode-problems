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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode node = head;
        ListNode previous = node;
        Map<Integer, Integer> values = new HashMap<>();
        
        while(node != null){
            int freq = values.getOrDefault(node.val, 0);
            values.merge(node.val, 1, Integer::sum);
            if(freq > 0){
                previous.next = node.next;
                node = previous.next;
            }else{
                previous = node;
                node = node.next;
            }
        }
        
        
        return head;
    }
}
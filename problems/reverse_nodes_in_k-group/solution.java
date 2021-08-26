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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<= 1){
            return head;
        }
        
        
        int count = 0;
        ListNode result = new ListNode();
        ListNode root   = result;
        int[] nums = new int[k];
        
        while(head != null){
            nums[count++] = head.val;
            head = head.next;
            
            if(count == k){
                for(int i=count-1; i>=0; i--){
                    root.val = nums[i];
                    if( ( i == 0 && head != null ) || i > 0){
                        root.next = new ListNode();
                        root = root.next;
                    }
                }
                count = 0;
            }
        }

        for(int i=0; i<count; i++){
            root.val = nums[i];
            if(i < count-1){
                root.next = new ListNode();
                root = root.next;
            }
        }
        
        
        return result;
    }
}
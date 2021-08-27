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
    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> data = new ArrayList<>();
        while(head != null){
            data.add(head.val);
            head = head.next;
        }
        
        int startIndex = k-1;
        int endIndex   = data.size() - k;
        Collections.swap(data, startIndex, endIndex);
        
       
        ListNode result = new ListNode();
        ListNode root = result;        
        for(int i=0; i<data.size(); i++){
            root.val = data.get(i);
            if(i < data.size() -1 ){
                root.next = new ListNode();
                root = root.next;
            }
        }
        
        
      return result;  
    }
}
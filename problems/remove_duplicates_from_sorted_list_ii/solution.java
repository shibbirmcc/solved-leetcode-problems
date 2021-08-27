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
        
        Map<Integer, Integer> frequency = new HashMap<>();
        while(head != null){
           frequency.merge(head.val, 1, Integer::sum);
           head = head.next;
        }
        
        List<Integer> dataSet = frequency.entrySet().stream().filter(entry -> entry.getValue() == 1).map(entry -> entry.getKey()).collect(Collectors.toList());
        
        if(dataSet == null || dataSet.isEmpty()){
            return null;
        }
        
        Collections.sort(dataSet);

        ListNode result = new ListNode();
        ListNode root   = result;
        for(int i=0; i<dataSet.size(); i++){
                root.val = dataSet.get(i);
                if(i < dataSet.size() - 1){
                    root.next = new ListNode();
                    root = root.next;
                } 
        }
      return result;  
    }
}
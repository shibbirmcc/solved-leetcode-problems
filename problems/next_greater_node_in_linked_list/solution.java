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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> values  = new ArrayList<>();
        ListNode root = head;
        while(root != null){
            values.add(root.val);
            root = root.next;
        }
        
        int[] result = new int[values.size()];
        Stack<Integer> stack = new Stack<>();
        for(int i=values.size() - 1; i>= 0; i--){
            int val = values.get(i);
            
            while(!stack.isEmpty() && stack.peek() <= val){
                stack.pop();
            }
            
            result[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(val);
        }
        
        return result;
    }
}
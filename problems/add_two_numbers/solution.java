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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node = new ListNode();
		int remainder = 0;
		ListNode current = node;
		
		while(l1 != null || l2 != null) {
			int n1 = l1 == null ? 0 : l1.val;
			int n2 = l2 == null ? 0 : l2.val;
			
			int sum = n1 + n2 + remainder;
			int n3 = sum % 10;
			remainder = sum / 10;
			current.val = n3;
			
			if(l1 != null) {
				l1 = l1.next;
			}
			if(l2 != null) {
				l2 = l2.next;
			}
			if(l1 != null || l2 != null || remainder > 0) {
				current.next = new ListNode();
				current = current.next;
			}
			
		}
		while(remainder > 0) {
			int n3 = remainder % 10;
			current.val = n3;
			remainder = remainder / 10;
			if(remainder > 0) {
				current.next = new ListNode();
				current = current.next;
			}
		}
		current = null;		
		return node;
    }
}
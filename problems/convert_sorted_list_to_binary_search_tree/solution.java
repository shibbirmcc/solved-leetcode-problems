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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	    public TreeNode sortedListToBST(ListNode head) {
	    	List<Integer> nums = getDataList(head);
	        return constructTree(nums, 0, nums.size() - 1);
	    }
	    
	    private List<Integer> getDataList(ListNode head){
	    	List<Integer> data = new ArrayList<>();
	    	while(head != null) {
	    		data.add(head.val);
	    		head = head.next;
	    	}
	    	return data;
	    }
	    
		private TreeNode constructTree(List<Integer> nums, int leftIndex, int rightIndex) {
			if (leftIndex > rightIndex) {
				return null;
			}
			int pivot = (leftIndex + rightIndex) / 2;
			TreeNode root = new TreeNode(nums.get(pivot));
			root.left = constructTree(nums, leftIndex, pivot - 1);
			root.right = constructTree(nums, pivot + 1, rightIndex);
			return root;
		}
}
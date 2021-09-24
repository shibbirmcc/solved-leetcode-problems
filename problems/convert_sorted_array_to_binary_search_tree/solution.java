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
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructTree(nums, 0, nums.length - 1);
    }
    
	private TreeNode constructTree(int[] nums, int leftIndex, int rightIndex) {
		if (leftIndex > rightIndex) {
			return null;
		}
		int pivot = (leftIndex + rightIndex) / 2;
		TreeNode root = new TreeNode(nums[pivot]);
		root.left = constructTree(nums, leftIndex, pivot - 1);
		root.right = constructTree(nums, pivot + 1, rightIndex);
		return root;
	}
}
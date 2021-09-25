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
	 public class NodeHeight{
		 TreeNode node;
		 int height;
		 NodeHeight(TreeNode node, int height){
			 this.node = node;
			 this.height = height;
		 }
	 }
	 
    public int minDepth(TreeNode root) {
    	
        if(root == null){
            return 0;
        }
        
    	Queue<NodeHeight> queue = new LinkedList<>();
    	queue.offer(new NodeHeight(root, 1));
    	
    	while(!queue.isEmpty()) {
    		NodeHeight nodeHeight = queue.poll();
    		TreeNode node = nodeHeight.node;
    		int height = nodeHeight.height;
    		if(node.left == null && node.right == null) {
    			return height;
    		}
    		
    		if(node.left != null) {
    			queue.offer(new NodeHeight(node.left, height+1));
    		}
    		
    		if(node.right != null) {
    			queue.offer(new NodeHeight(node.right, height+1));
    		}
    	}
    	
    	
        return 0;
    }
}
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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
       Set<Integer> tree1Data = new HashSet<>();
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root1);
       while(!queue.isEmpty()) {
    	   TreeNode node = queue.poll();
    	   tree1Data.add(node.val);
    	   
    	   if(node.left != null) {
    		   queue.offer(node.left);
    	   }
    	   
    	   if(node.right != null) {
    		   queue.offer(node.right);
    	   }
       }

       queue.add(root2);
       
       while(!queue.isEmpty()) {
    	   TreeNode node = queue.poll();
    	   int tree1LookFor = target - node.val;
    	   
    	   if(tree1Data.contains(tree1LookFor)) {
    		   return true;
    	   }
    	   
    	   if(node.left != null) {
    		   queue.offer(node.left);
    	   }
    	   
    	   if(node.right != null) {
    		   queue.offer(node.right);
    	   }
       }
    	return false;
    }
}
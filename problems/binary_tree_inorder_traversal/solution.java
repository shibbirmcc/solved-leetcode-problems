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
    private List<Integer> traversedList = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traversedList.clear();
        inOrder(root);
        return traversedList;
    }
    
    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        
        inOrder(root.left);
        
        traversedList.add(root.val);
        
        inOrder(root.right);
    }
}
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.right != null){
                root.val = getInorderSuccessor(root.right).val;
                root.right = deleteNode(root.right, root.val);
            }else if(root.left != null){
                root.val = getInorderPredecessor(root.left).val;
                root.left = deleteNode(root.left, root.val);
            }else{
                root = null;
            }
        }
        
        return root;
    }
    
    
    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
    
    private TreeNode getInorderSuccessor(TreeNode node){
        while(node.left != null && !isLeaf(node)){
            node = node.left;
        }
        return node;
    }
    
    private TreeNode getInorderPredecessor(TreeNode node){
        while(node.right != null && !isLeaf(node)){
            node = node.right;
        }
        return node;
    }
}
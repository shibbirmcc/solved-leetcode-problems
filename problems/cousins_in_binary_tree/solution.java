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
    public boolean isCousins(TreeNode root, int x, int y) {
        int xHeight = 0;
        int xParent = 0;
        int yHeight = 0;
        int yParent = 0;
        
        int[] heights = new int[101];
        heights[root.val] = 1;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty() && (xHeight == 0 || yHeight == 0)){
            TreeNode node = queue.poll();
            int height = heights[node.val];
            
            if(node.left != null){
                heights[node.left.val] =  height + 1;
                if(node.left.val == x){
                    xHeight = height + 1;
                    xParent = node.val;
                }else if(node.left.val == y){
                    yHeight = height + 1;
                    yParent = node.val;
                }else{
                    queue.offer(node.left);
                }
            }
            
            if(node.right != null){
                heights[node.right.val] =  height + 1;
                if(node.right.val == x){
                    xHeight = height + 1;
                    xParent = node.val;
                }else if(node.right.val == y){
                    yHeight = height + 1;
                    yParent = node.val;
                }else{
                    queue.offer(node.right);
                }
            }
            
        }
        
        
        
        
        return xHeight > 0 && xHeight == yHeight && xParent > 0 && yParent > 0 && xParent != yParent;
    }
}
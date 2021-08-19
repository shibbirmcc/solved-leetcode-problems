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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<List<TreeNode>> roots = new LinkedList<>();
        roots.offer(List.of(root));
        result.add(List.of(root.val));
        
        while(!roots.isEmpty()){
            List<TreeNode> nodes = roots.poll();
            List<TreeNode> nextNodes = new ArrayList<>();
            List<Integer> children = new ArrayList<>();
            for(TreeNode node: nodes){
                TreeNode left = node.left;
                TreeNode right = node.right;
                
                if(left != null){
                    children.add(left.val);
                    nextNodes.add(left);
                }
                
                if(right != null){
                    children.add(right.val);
                    nextNodes.add(right);
                }
            }
            
            if(!children.isEmpty()){
                result.add(children);
            }
            
            if(!nextNodes.isEmpty()){
                roots.offer(nextNodes);
            }
        }
        
        
       return result; 
    }
}
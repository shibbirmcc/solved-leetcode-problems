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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<List<TreeNode>> roots = new LinkedList<>();
        roots.offer(List.of(root));
        result.add(List.of(root.val));
        
        boolean leftToRight = true;
        
        while(!roots.isEmpty()){
            leftToRight = leftToRight ? false : true;
            List<TreeNode> nodes = roots.poll();
            List<TreeNode> nextNodes = new ArrayList<>();
            List<Integer> children = new ArrayList<>();
            for(TreeNode node: nodes){
                TreeNode left = node.left;
                TreeNode right = node.right;
                addNodeValues(left, right, children);
                addNodes(left, right, nextNodes);
            }
            
            if(!children.isEmpty()){
                if(!leftToRight){
                    Collections.reverse(children);
                }
                result.add(children);
            }
            
            if(!nextNodes.isEmpty()){
                roots.offer(nextNodes);
            }
            
            System.out.println(leftToRight+" : "+children.toString());
        }

       return result; 
    }
    
    
    private void addNodes(TreeNode left, TreeNode right, List<TreeNode> nextNodes){
        if(left != null){
            nextNodes.add(left);
        }

        if(right != null){
            nextNodes.add(right);
        }
    }
    
    private void addNodeValues(TreeNode left, TreeNode right, List<Integer> children){
        if(left != null){
            children.add(left.val);
        }

        if(right != null){
            children.add(right.val);
        }
    }
    
    
}
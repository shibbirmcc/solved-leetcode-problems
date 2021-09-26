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
    public final long MOD = 1000000007;
    private List<Long> nodeSum = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        nodeSum.clear();
        long totalSum = calculateSumWithPostOrderTraversal(root);
        long maxProduct = 0;
        
        for(long sum : nodeSum){
            long product = ( totalSum - sum ) * sum;
            maxProduct = Math.max(maxProduct, product);
        }
        
        return (int)( maxProduct % MOD );
    }
    
    
    private long calculateSumWithPostOrderTraversal(TreeNode root){
        if(root == null){
            return 0;
        }
        long leftNodeSum = calculateSumWithPostOrderTraversal(root.left);
        long rightNodeSum = calculateSumWithPostOrderTraversal(root.right);
        long totalSum = root.val + leftNodeSum + rightNodeSum;
        nodeSum.add(totalSum);
        return totalSum;
    }
    
}
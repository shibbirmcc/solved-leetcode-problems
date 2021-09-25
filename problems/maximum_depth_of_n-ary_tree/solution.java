/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
	 public class NodeHeight{
		 Node node;
		 int height;
		 NodeHeight(Node node, int height){
			 this.node = node;
			 this.height = height;
		 }
	 }
    
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        Queue<NodeHeight> queue = new LinkedList<>();
        queue.offer(new NodeHeight(root, 1));
        int maxDepth = 0;
        while(!queue.isEmpty()){
            NodeHeight nodeHeight = queue.poll();
            maxDepth = Math.max(maxDepth, nodeHeight.height);
            if(nodeHeight.node.children != null){
                for(Node node : nodeHeight.node.children){
                    queue.offer(new NodeHeight(node, nodeHeight.height + 1));
                }
            }
        }
        return maxDepth;
    }
}
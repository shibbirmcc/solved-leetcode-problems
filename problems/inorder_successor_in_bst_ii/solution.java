class Solution {
    public Node inorderSuccessor(Node node) {
        Node root = node;
        while(root.parent != null){
           root = root.parent;
        }
        Node successor = null;
        while(root != null){
            if(node.val >= root.val){
                root = root.right;
            }else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}
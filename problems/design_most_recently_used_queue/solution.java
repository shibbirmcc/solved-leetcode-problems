class MRUQueue{
    
    private class Node{
        int value;
        Node next;
        Node previous;
        public Node(){
            value = -1;
        }
        public Node(int v){
            value = v;
        }
    }
    
    private Node head = new Node();
    private Node tail = new Node();

    public MRUQueue(int n) {
        head.next = tail;
        tail.previous = head;
        for(int i=1; i<= n; i++){
            addNode(new Node(i));
        }
    }
    
    public int fetch(int k) {
        Node node = head;
        for(int i=1; i<= k; i++){
            node = node.next;
        }
        moveToHead(node);
        return node.value;
    }
    
    
    
    private void addNode(Node node){
        tail.previous.next = node;
        node.previous = tail.previous;
        tail.previous = node;
        node.next = tail;
    }
    
    private void moveToHead(Node node){
        node.previous.next = node.next;
        node.next.previous = node.previous;
        addNode(node);
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */
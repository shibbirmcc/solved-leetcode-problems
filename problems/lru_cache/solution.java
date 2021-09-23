class LRUCache {
	private class Node{
		int index;
		int value;
		Node previous;
		Node next;
		
		public Node() {
			value = -1;
		}
		
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
	Node head;
	Node tail;

	private HashMap<Integer, Node> values = new HashMap<>();
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.previous = head;
	}

	public int get(int key) {
		Node node = values.remove(key);
		if(node != null) {
			deleteNode(node);
			addNode(node);
			return node.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		Node newNode = new Node(key, value);
		Node existingNode = values.remove(key);
		if(existingNode != null) {
			deleteNode(existingNode);
		}
		addNode(newNode);
		evictLru();
	}
	
	private void evictLru() {
		if(values.size() > capacity) {
			Node node = tail.previous;
			if(node != null){
				deleteNode(node);	
			}
		}
	}

	private void addNode(Node node) {
		node.previous = head;
		node.next     = head.next;
		node.next.previous = node;
		head.next     = node;
		values.put(node.index, node);
	}

	private void deleteNode(Node node) {
		node.previous.next = node.next;
		node.next.previous = node.previous;
		values.remove(node.index);
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
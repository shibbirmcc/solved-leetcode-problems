class MyHashSet {
    private final int MAX = 1000001;
    private boolean[] mapData;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        mapData = new boolean[MAX];
    }
    
    public void add(int key) {
        mapData[key] = true;
    }
    
    public void remove(int key) {
        mapData[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return mapData[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
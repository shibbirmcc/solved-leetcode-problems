import java.util.TreeSet;
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
    	int n = heights.length;
    	int[] revHeights = new int[n];
    	int[] result = new int[n];
    	for(int i=n-1, j=0; i>=0 && j<n; i--, j++) {
    		revHeights[j] = heights[i];
    	}
    	
    	Deque<Integer> dequeue = new ArrayDeque<>();
    	for(int i=0, j=n-1; i<n && j>=0; i++, j--) {
    		int h = revHeights[i];
    		while(!dequeue.isEmpty() && dequeue.peek() < h) {
    			result[j]++;
    			dequeue.pop();
    		}
    		result[j] += dequeue.isEmpty() ? 0 : 1;
    		dequeue.push(h);
    	}

        return result;
    }
}
class Solution {
    public int firstMissingPositive(int[] nums) {
    	int length = nums.length;
    	boolean[] isPresent = new boolean[length + 1];
    	
    	for(int n : nums) {
    		if(n > 0 && n <= length) {
    			isPresent[n] = true;
    		}
    	}
    	
    	for(int i=1; i<=length; i++) {
    		if(!isPresent[i]) {
    			return i;
    		}
    	}
    	return length+1;
    }
}
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
	private int MAX = 1001;
	private boolean[] exists = new boolean[MAX];
	private Stack<Integer> stack = new Stack<>();
	
    public boolean canBeIncreasing(int[] nums) {
    	
    	stack.clear();
    	Arrays.fill(exists, false);
    	exists[nums[0]] = true;
    	stack.push(nums[0]);
    	
    	
        int decreasingNumberCount = 0;
        Set<Integer> numbers = new HashSet<>(); 
        
        
        numbers.add(nums[0]);
        
        for(int i=1; i<nums.length; i++) {
        	if(exists[nums[i]]) {
        		decreasingNumberCount++;
        	}else if(!stack.isEmpty() && stack.peek() > nums[i]) {
    			int peek = stack.pop();
    			exists[peek] = false;
    			
    			if(!stack.isEmpty() && stack.peek() > nums[i]) {
    				exists[peek] = true;
    				stack.push(peek);
    			}else {
    				exists[nums[i]] = true;
    				stack.push(nums[i]);
    			}
    			
    			decreasingNumberCount++;
        	}else {
        		exists[nums[i]] = true;
        		stack.push(nums[i]);
        	}
        }
        return decreasingNumberCount <= 1;
    }
}
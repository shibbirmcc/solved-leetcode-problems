import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] twoSum(int[] nums, int target) {
    	Map<Integer, Queue<Integer>> indexMap = new HashMap<>();
    	
    	for(int i=0; i<nums.length; i++) {
    		int n = nums[i];
    		Queue<Integer> indices = indexMap.computeIfAbsent(n, f -> new LinkedList());
    		indices.offer(i);
    	}
    	
    	for(int i=0; i<nums.length; i++) {
    		Integer n = nums[i];
    		Queue<Integer> nIndices = indexMap.get(n);
    		int nIndex = nIndices.poll();
    		
    		Integer remainignNumber = target - n;
    		
    		if(remainignNumber == n) {
    			if(!nIndices.isEmpty()) {
    				return new int[] {nIndex, nIndices.poll()};
    			}else {
    				continue;
    			}
    		}
    		
    		
    		Queue<Integer> indices = indexMap.get(remainignNumber);
    		
    		
    		if(indices != null && !indices.isEmpty()) {
    			return new int[] {nIndex, indices.poll()};
    		}
    	}
    	return null;
    }
}
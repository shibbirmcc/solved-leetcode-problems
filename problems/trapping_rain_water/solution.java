class Solution {
    public int trap(int[] height) {
    	int i = 0, j = height.length - 1;
    	int maxLeft = 0, maxRight = 0;
    	int water = 0;
    	
    	while(i <= j) {
    		if(height[i] < height[j]) {
    			if(maxLeft < height[i]) {
    				maxLeft = height[i];
    			}else {
    				water +=  maxLeft - height[i];
    			}
    			i++;
    		}else {
    			
    			if(maxRight < height[j]) {
    				maxRight = height[j];
    			}else {
    				water +=  maxRight - height[j];
    			}
    			j--;
    		}
    	}
    	return water;
    }
}
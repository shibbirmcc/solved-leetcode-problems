class Solution {
    public int findMiddleIndex(int[] nums) {
        if(nums.length == 1) {
        	return 0;
        }

        int length = nums.length;
        int[] leftSum = new int[length];
        int[] rightSum = new int[length];
        
        leftSum[0] = nums[0];
        rightSum[length - 1] = nums[length -1];
        
        for(int i=1, j = length-2; i<length && j >= 0; i++, j--) {
        	leftSum[i] = leftSum[i - 1] + nums[i];
        	rightSum[j] = rightSum[j + 1] + nums[j]; 
        }

        int leftMostMiddleIndex = -1;
        
        for(int i=0; i<length && leftMostMiddleIndex < 0; i++) {
        	if(i == 0) {
        		leftMostMiddleIndex = rightSum[ i + 1] == 0 ? i : -1;
        	} else if(i == length - 1) {
        		leftMostMiddleIndex = leftSum[i - 1] == 0 ? i : -1;
        	}else if(leftSum[i - 1] == rightSum[ i + 1]){
            		leftMostMiddleIndex = i;
            }	
        }

    	return leftMostMiddleIndex;
    }
}
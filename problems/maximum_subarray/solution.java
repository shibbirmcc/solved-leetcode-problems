class Solution {
    public int maxSubArray(int[] nums) {
      
        int currentIndex = 1;
        int currentSum = nums[0];
        int maxSum = currentSum;
        
        while(currentIndex < nums.length){
            int num = nums[currentIndex++];
            currentSum  = Math.max(num, num + currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
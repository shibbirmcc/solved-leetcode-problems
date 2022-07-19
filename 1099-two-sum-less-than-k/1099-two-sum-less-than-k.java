class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
     TreeSet<Integer> numSet = new TreeSet();
     int maxSum = -1;
        
     for(int i=0; i<nums.length; i++){
         if(nums[i] < k){
             int complement = k - nums[i];
             Integer lower = numSet.lower(complement);
             if(lower != null){
                 maxSum = Math.max(maxSum, nums[i] + lower.intValue());
             }
             numSet.add(nums[i]);   
         }
     } 
    
        return maxSum;
    }
}
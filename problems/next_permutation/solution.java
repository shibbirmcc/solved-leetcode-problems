class Solution {
    public void nextPermutation(int[] nums) {
    	int targetIndex = nums.length - 2;
        
        while( targetIndex >= 0 && nums[targetIndex] >= nums[targetIndex + 1]){
            targetIndex--;
        }
        
        if(targetIndex >= 0){
            int targetForSwap = nums.length - 1;
            while(targetForSwap > targetIndex && nums[targetForSwap] <= nums[targetIndex]){
                targetForSwap--;
            }
            swap(nums, targetIndex, targetForSwap);
            reverse(nums, targetIndex + 1, nums.length - 1);
        }else{
            reverse(nums, 0, nums.length - 1);
        }
    }
    
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
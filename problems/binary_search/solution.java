class Solution {
    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while(rightIndex >= leftIndex){
            int index = (leftIndex + rightIndex)/2;
            if(target > nums[index]){
                leftIndex = index + 1;
            }else if(target < nums[index]){
                rightIndex = index - 1;
            }else{
                return index;
            }
        }
    return -1; 
    }
}
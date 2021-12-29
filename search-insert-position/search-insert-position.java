class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = (start + end)/2;

        while(end >= start){
            index = (start + end)/2;
            if(target > nums[index]){
                start = index + 1;
            }else if(target < nums[index]){
                end = index - 1;
            }else{
                break;
            }
        }
        
        if(target > nums[index]){
            return index + 1;
        }else if(target < nums[index]){
            if(index > 0 && target > nums[index - 1]){
                return index;
            } else if(index > 0){
                return index - 1;
            }else{
                return index;
            }
        }else{
            return index;
        }
    }
}
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] indices = new int[]{-1, -1};
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                if(indices[0] == -1){
                    indices[0] = i;
                }else{
                    indices[1] = i;
                }
            }else if(indices[0] != -1){
                break;
            }
        }
        
        indices[1] = (indices[0] != -1 && indices[1] == -1) ? indices[0] : indices[1];
        
        return indices;
    }
}
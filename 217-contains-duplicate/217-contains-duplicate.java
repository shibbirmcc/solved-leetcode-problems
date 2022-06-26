class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(numSet.contains(nums[i])){
                return true;
            }else{
                numSet.add(nums[i]);
            }
        }
        return false;
    }
}
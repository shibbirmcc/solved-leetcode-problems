class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastIndexMap = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            Integer lastIndex = lastIndexMap.get(nums[i]);
            if(lastIndex != null && Math.abs(i - lastIndex.intValue()) <= k){
                return true;
            }
            lastIndexMap.put(nums[i], i);
        }
        return false;
    }
}
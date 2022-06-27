class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, TreeSet<Integer>> indices = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            indices.computeIfAbsent(nums[i], f -> new TreeSet()).add(i);
        }
        
        for(int i=0; i < nums.length; i++){
            TreeSet<Integer> numberIndices = indices.get(nums[i]);
            if(numberIndices.size() > 1){
                Integer lowestIndex  = numberIndices.higher(i);
                if(lowestIndex != null && Math.abs(lowestIndex.intValue() - i) <= k ){
                    return true;
                }
                
            }
        }
        
      return false;  
    }
}
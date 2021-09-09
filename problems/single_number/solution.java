class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Set<Integer>> frequencyNumberMap = new HashMap<>(nums.length);
        Map<Integer, Integer> frequency = new HashMap<>(nums.length);
        
        for(int i=0; i<nums.length; i++){
           frequency.merge(nums[i], 1, Integer::sum);
           int newFreq = frequency.get(nums[i]);
           frequencyNumberMap.computeIfAbsent(newFreq, f-> new HashSet<>()).add(nums[i]);
            if(newFreq > 1){
                frequencyNumberMap.get(newFreq - 1).remove(nums[i]);
            }
        }
        return frequencyNumberMap.get(1).stream().findFirst().get();
    }
}
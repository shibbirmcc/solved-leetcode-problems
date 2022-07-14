class Solution {
    
    

public int[] twoSum(int[] numbers, int target) {
    Map<Integer, Integer> valueIndexMap = new HashMap(numbers.length + 1, 1);
    valueIndexMap.put(numbers[0], 0);
    for(int i=1; i<numbers.length; i++){
        int complement = target - numbers[i];
        Integer complementIndex = valueIndexMap.get(complement);
        if(complementIndex != null){
            return new int[]{complementIndex.intValue() + 1, i+1};
        }
        
        valueIndexMap.put(numbers[i], i);
    }
    return new int[]{};
}
    
}
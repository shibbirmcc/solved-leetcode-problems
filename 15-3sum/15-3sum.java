class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> existingTrippletHash = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            result.addAll(findNext2Ints(nums, nums[i], i+1, existingTrippletHash));
        }
        return result;
    }

    private List<List<Integer>> findNext2Ints(int[] nums, int currentValue, int startIndex, Set<String> existingTrippletHash){
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> leftSet = new HashSet<>();
        for(int i= startIndex; i<nums.length; i++){
            int requiredLeftSetValue = 0 - (currentValue + nums[i]);
            if(leftSet.contains(requiredLeftSetValue)){
                String hash = getArrayHash(currentValue, requiredLeftSetValue, nums[i]);
                if(!existingTrippletHash.contains(hash)){
                    result.add(new ArrayList<>(Arrays.asList(currentValue, requiredLeftSetValue, nums[i])));
                    existingTrippletHash.add(hash);
                }
            }
            leftSet.add(nums[i]);
        }
        return result;
    }


    private String getArrayHash(int a, int b, int c){
        int[] array = new int[]{a,b,c};
        Arrays.sort(array);
        return Arrays.toString(array);
    }
}
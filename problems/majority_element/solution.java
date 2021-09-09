class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int threshold = n/2;
        Map<Integer, Integer> frequency = new HashMap<>(n);
        
        for(int i =0; i<n; i++){
         int f = frequency.merge(nums[i], 1, Integer::sum);
         if(f > (n/2)){
             return nums[i];
         }
        }
        
        return 0;
    }
}
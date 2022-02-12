class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        int[] hist = new int[101];
        for(int i=0; i< nums.length; i++){
          if(hist[nums[i]] > 0){
              count += hist[nums[i]];
          }
          hist[nums[i]]++;
        }
        return count;
    }
}